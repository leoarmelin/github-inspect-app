package com.example.github_inspect_app.repository

import com.example.github_inspect_app.service.GithubService

class GithubRepository(
    private val githubService: GithubService
) {

    fun getUsers() = githubService.getUsers()
}