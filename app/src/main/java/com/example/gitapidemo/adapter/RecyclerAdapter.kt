package com.example.gitapidemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gitapidemo.R
import com.example.gitapidemo.model.GithubUser

class RecyclerAdapter(private val userList: ArrayList<GithubUser>) : RecyclerView.Adapter<RecyclerAdapter.UserData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserData {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_layout, null)
        return UserData(view)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserData, position: Int) {

        val data = userList[position]
        holder.bindItems(data)
    }



    class UserData(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var userName = itemView.findViewById<TextView>(R.id.textView)
        var userProfile = itemView.findViewById<ImageView>(R.id.imageView)
            fun bindItems(data: GithubUser) {
                userName.setText(data.login)

                Glide.with(itemView)
                    .load(data.avatarUrl)
                    .centerCrop()
                    .into(userProfile)

            }
    }

}