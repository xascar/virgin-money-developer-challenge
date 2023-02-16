package dev.xascar.virginmoneydeveloperchallenge.ui.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModel
import dev.xascar.virginmoneydeveloperchallenge.data.repository.Repository
import dev.xascar.virginmoneydeveloperchallenge.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _result = MutableLiveData<ResponseType<RoomModel>>()
    val result: LiveData<ResponseType<RoomModel>> = _result

    fun getRoomList() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getRoomList()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }
}