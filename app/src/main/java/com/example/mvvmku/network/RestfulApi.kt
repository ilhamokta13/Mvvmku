package com.example.mvvmku.network


import com.example.mvvmku.model.GetAllUser
import com.example.mvvmku.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {

    @GET("user")
    fun getAllUser(): Call<List<GetAllUserItem>>
}