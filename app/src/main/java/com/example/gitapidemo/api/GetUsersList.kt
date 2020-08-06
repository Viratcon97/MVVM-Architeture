package com.example.gitapidemo.api

import com.example.gitapidemo.model.GithubUser
import retrofit2.http.GET
import io.reactivex.Observable

interface GetUsersList {

    @GET("/users")
    fun getUserData(): Observable<ArrayList<GithubUser>>
}