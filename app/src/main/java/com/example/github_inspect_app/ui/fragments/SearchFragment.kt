package com.example.github_inspect_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.github_inspect_app.R
import com.example.github_inspect_app.databinding.FragmentSearchBinding
import com.example.github_inspect_app.factory.GithubViewModelFactory
import com.example.github_inspect_app.repository.GithubRepository
import com.example.github_inspect_app.service.GithubService
import com.example.github_inspect_app.viewModel.GithubViewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: GithubViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSend.setOnClickListener {
            viewModel.getUsers()
            findNavController().navigate(R.id.listFragment)
        }
    }

}