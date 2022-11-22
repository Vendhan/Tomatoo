package com.vendhan.tomatoo.repo

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.vendhan.tomatoo.di.CoroutinesDispatchersModule
import com.vendhan.tomatoo.repo.model.RemoteModel
import com.vendhan.tomatoo.repo.service.HomePageApi
import com.vendhan.tomatoo.utils.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class HomePageRepoImpl @Inject constructor(
    private val homePageApi: HomePageApi,
    private val gson: Gson,
    @ApplicationContext private val context: Context,
    @CoroutinesDispatchersModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : HomePageRepo {
    override suspend fun fetchHomePageData(): Flow<Result<RemoteModel>> {
        return withContext(ioDispatcher) {
            flow {
                emit(Result.Loading)
                try {
                    val result = homePageApi.fetchHomePageData()
                    // val result = parseLocalJson()
                    emit(
                        Result.Success(
                            data = result
                        )
                    )
                } catch (e: Exception) {
                    Log.e("Error", e.toString())
                    emit(
                        Result.Error(
                            message = ""
                        )
                    )
                }
            }
        }
    }

    private fun parseLocalJson(): RemoteModel {

        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("SampleData.json")
                .bufferedReader()
                .use { it.readText() }
                .replace("\n", "")
        } catch (ioException: IOException) {
        }
        return gson.fromJson(jsonString, RemoteModel::class.java)
    }
}
