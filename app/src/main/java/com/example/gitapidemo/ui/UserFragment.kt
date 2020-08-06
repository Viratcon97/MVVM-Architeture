package com.example.gitapidemo.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapidemo.R
import com.example.gitapidemo.adapter.RecyclerAdapter
import com.example.gitapidemo.model.GithubUser
import com.example.gitapidemo.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel


    lateinit var adapter : RecyclerAdapter
    var userList: ArrayList<GithubUser> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*   pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
               setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
           }
       */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_user, container, false)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        userViewModel.getUserList()

        userViewModel.githubusers.observe(activity!!, Observer {

                Log.d("Test","$it")

            userList = it
            adapter = RecyclerAdapter(userList)
            recyclerView.layoutManager =LinearLayoutManager(activity)
            recyclerView.adapter=adapter
            adapter.notifyDataSetChanged()
        })
        return root
    }

}