package com.example.mvvmku.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmku.model.GetAllUserItem
import com.example.mvvmku.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    var liveDataUser : MutableLiveData<List<GetAllUserItem>> = MutableLiveData()

    fun getliveDataUser() :MutableLiveData<List<GetAllUserItem>>{
        return  liveDataUser
    }


    fun callApiUser() {

        ApiClient.instance.getAllUser().enqueue(object : Callback<List<GetAllUserItem>>{
            override fun onResponse(
                call: Call<List<GetAllUserItem>>,
                response: Response<List<GetAllUserItem>>
            ) {

                if (response.isSuccessful) {
                    liveDataUser.postValue(response.body())
                } else {
                    liveDataUser.postValue(null)
                }

            }

            override fun onFailure(call: Call<List<GetAllUserItem>>, t: Throwable) {
                liveDataUser.postValue(null)
            }

        })

    }


}