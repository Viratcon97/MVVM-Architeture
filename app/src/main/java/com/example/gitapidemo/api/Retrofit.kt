package com.example.gitapidemo.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofit {

    var gson = GsonBuilder().setLenient().create()


    var logging = HttpLoggingInterceptor()
    var httpClient = OkHttpClient.Builder()

    fun getUserList(): GetUsersList {

        logging.level = HttpLoggingInterceptor.Level.BODY

        httpClient.connectTimeout(2, TimeUnit.MINUTES)
        httpClient.readTimeout(2, TimeUnit.MINUTES)
        httpClient.addInterceptor(logging)

        val retrofit =
            retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return retrofit.create(GetUsersList::class.java)

    }
    companion object {
        private const val BASE_URL = "https://api.github.com/"
    }

}