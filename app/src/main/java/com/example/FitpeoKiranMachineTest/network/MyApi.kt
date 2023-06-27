package com.example.FitpeoKiranMachineTest.network

import com.example.FitpeoKiranMachineTest.Constants.GET_PHOTOS
import com.example.FitpeoKiranMachineTest.models.GetPhotosResponse
import retrofit2.http.GET

interface MyApi {
    @GET(GET_PHOTOS)
    suspend fun getPhotos(): GetPhotosResponse
}