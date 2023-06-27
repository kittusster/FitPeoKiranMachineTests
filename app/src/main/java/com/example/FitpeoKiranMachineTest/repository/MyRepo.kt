package com.example.FitpeoKiranMachineTest.repository

import com.example.FitpeoKiranMachineTest.network.MyApi
import javax.inject.Inject

class MyRepo @Inject constructor(private val myApi: MyApi) {

    suspend fun getPhotos() = myApi.getPhotos()
}