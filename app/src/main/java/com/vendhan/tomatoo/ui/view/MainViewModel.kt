package com.vendhan.tomatoo.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendhan.tomatoo.repo.HomePageRepo
import com.vendhan.tomatoo.repo.model.RemoteModel
import com.vendhan.tomatoo.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val homePageRepo: HomePageRepo
) : ViewModel() {

    private val _data = MutableStateFlow<Result<RemoteModel>>(Result.Loading)
    val data: StateFlow<Result<RemoteModel>>
        get() = _data

    init {
        fetchUI()
    }

    private fun fetchUI() {
        viewModelScope.launch {
            homePageRepo
                .fetchHomePageData()
                .catch {
                    _data.value = Result.Error(message = "")
                }
                .collect {
                    _data.value = it
                }
        }
    }
}
