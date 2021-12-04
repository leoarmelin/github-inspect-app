package com.example.github_inspect_app.service

import com.example.github_inspect_app.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GithubService {

    @GET("users")
    fun getUsers(): Call<List<User>>

    companion object {

        var githubService: GithubService? = null

        fun getInstance(): GithubService {
            if (githubService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                githubService = retrofit.create(GithubService::class.java)
            }

            return githubService!!
        }
    }
}