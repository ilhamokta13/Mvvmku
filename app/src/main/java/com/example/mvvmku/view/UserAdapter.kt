package com.example.mvvmku.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmku.databinding.ItemUserBinding
import com.example.mvvmku.model.GetAllUserItem

class UserAdapter(var listuser : List<GetAllUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemUserBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.name.text = listuser[position].name
        holder.binding.age.text = listuser[position].age.toString()
        holder.binding.address.text = listuser[position].address
        holder.binding.email.text = listuser[position].email
        holder.binding.username.text = listuser[position].username
        holder.binding.pass.text = listuser[position].password
    }

    override fun getItemCount(): Int {
        return listuser.size
    }
}