package com.example.FitpeoKiranMachineTest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.FitpeoKiranMachineTest.models.PhotoModel
import com.example.FitpeoKiranMachineTest.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MyRepo) : ViewModel() {

    val isLoading = MutableStateFlow(false)

    private val _photosList = MutableLiveData<List<PhotoModel>>()
    val photosList: LiveData<List<PhotoModel>>
        get() = _photosList

    init {
        getPhotos()
    }

    private fun getPhotos() = viewModelScope.launch {
        isLoading.value = true
        _photosList.postValue(repo.getPhotos())
        isLoading.value = false
    }
}