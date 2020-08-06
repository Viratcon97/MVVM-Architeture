package com.example.gitapidemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GithubUser(

    @Expose
    @SerializedName("login")
    var login: String,

    @Expose
    @SerializedName("avatar_url")
    var avatarUrl: String,

    @Expose
    @SerializedName("name")
    var name: String,

    @Expose
    @SerializedName("bio")
    var bio: String,

    @Expose
    @SerializedName("public_repos")
    var publicRepos: Int,

    @Expose
    @SerializedName("followers")
    var followers: Int,

    @Expose
    @SerializedName("following")
    var following: Int
)