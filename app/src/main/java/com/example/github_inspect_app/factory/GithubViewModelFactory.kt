package com.example.github_inspect_app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github_inspect_app.repository.GithubRepository
import com.example.github_inspect_app.viewModel.GithubViewModel

class GithubViewModelFactory constructor(
    private val githubRepository: GithubRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(GithubViewModel::class.java)) {
            GithubViewModel(this.githubRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}