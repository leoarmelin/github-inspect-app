package com.example.github_inspect_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github_inspect_app.model.User
import com.example.github_inspect_app.repository.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubViewModel(
    private val githubRepository: GithubRepository
) : ViewModel() {

    val _usersListLiveData = MutableLiveData<List<User>>()
    val usersListLiveData = _usersListLiveData

    val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage

    fun getUsers() {

        val response = githubRepository.getUsers()

        response.enqueue(object: Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                _usersListLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                _errorMessage.postValue(t.message)
            }
        })
    }

}