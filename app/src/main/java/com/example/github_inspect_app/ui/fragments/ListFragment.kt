package com.example.github_inspect_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_inspect_app.adapter.UserListAdapter
import com.example.github_inspect_app.databinding.FragmentListBinding
import com.example.github_inspect_app.viewModel.GithubViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: GithubViewModel by activityViewModels()

    private val adapter = UserListAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUserList.adapter = adapter
        binding.rvUserList.layoutManager = LinearLayoutManager(context)

        viewModel.usersListLiveData.observe(viewLifecycleOwner, {
            adapter.setUsersList(it)
        })
    }
}