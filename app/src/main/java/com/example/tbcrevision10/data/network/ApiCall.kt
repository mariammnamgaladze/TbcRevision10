package com.example.tbcrevision10.data.network

import com.example.tbcrevision10.data.model.Message
import retrofit2.Response
import retrofit2.http.GET


interface ApiCall {
    @GET("v3/80d25aee-d9a6-4e9c-b1d1-80d2a7c979bf")
    suspend fun getApi(): Response<List<Message.MessageItem>>
}