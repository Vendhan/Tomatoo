package com.vendhan.tomatoo.repo.service

import com.vendhan.tomatoo.repo.model.RemoteModel
import retrofit2.http.GET

private const val TOKEN = "alt=media&token=e5715f01-667f-4ad5-9e43-571265f5d208"

interface HomePageApi {

    // @GET("o/SampleData.json?$TOKEN")
    @GET("getSDUIData")
    suspend fun fetchHomePageData(): RemoteModel
}


