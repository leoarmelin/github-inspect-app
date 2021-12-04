package com.example.github_inspect_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.github_inspect_app.databinding.ActivityMainBinding
import com.example.github_inspect_app.factory.GithubViewModelFactory
import com.example.github_inspect_app.repository.GithubRepository
import com.example.github_inspect_app.service.GithubService
import com.example.github_inspect_app.viewModel.GithubViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: GithubViewModel

    private val githubService = GithubService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(
            this,
            GithubViewModelFactory(GithubRepository(githubService))
        )[GithubViewModel::class.java]

        setContentView(binding.root)
    }
}