package com.example.mvvmku.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmku.R
import com.example.mvvmku.databinding.ActivityMainBinding
import com.example.mvvmku.model.GetAllUserItem
import com.example.mvvmku.network.ApiClient
import com.example.mvvmku.viewmodel.ViewModelUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var useradapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmAdapter()

    }

    fun setVmAdapter() {
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.getliveDataUser().observe(this, Observer {
            useradapter = UserAdapter(it)
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvUser.layoutManager = layoutManager
            binding.rvUser.adapter = UserAdapter(it)
        })

        viewModel.callApiUser()




    }
}