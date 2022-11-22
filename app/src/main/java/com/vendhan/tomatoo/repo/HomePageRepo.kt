package com.vendhan.tomatoo.repo

import com.vendhan.tomatoo.repo.model.RemoteModel
import com.vendhan.tomatoo.utils.Result
import kotlinx.coroutines.flow.Flow

interface HomePageRepo {

    suspend fun fetchHomePageData(): Flow<Result<RemoteModel>>
}
