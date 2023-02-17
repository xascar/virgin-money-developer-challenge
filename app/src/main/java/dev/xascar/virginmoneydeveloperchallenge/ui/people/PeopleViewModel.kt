package dev.xascar.virginmoneydeveloperchallenge.ui.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModel
import dev.xascar.virginmoneydeveloperchallenge.data.repository.Repository
import dev.xascar.virginmoneydeveloperchallenge.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModelItemModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PeopleViewModel"
@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    private val _result = MutableLiveData<ResponseType<PeopleModel>>()
    val result: LiveData<ResponseType<PeopleModel>> = _result

    private val _selectedUser = MutableLiveData<PeopleModelItemModel>()
    val selectedUser: LiveData<PeopleModelItemModel> = _selectedUser

    fun getPeopleList() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getPeopleList()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
                selectUser(response.body()!![0])
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }

    fun selectUser(selectedUser: PeopleModelItemModel){
        Log.d(TAG, "selectedUser: $selectedUser")
        _selectedUser.postValue(selectedUser)
    }

}