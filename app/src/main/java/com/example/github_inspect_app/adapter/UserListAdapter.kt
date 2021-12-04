package com.example.github_inspect_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_inspect_app.databinding.UserListBinding
import com.example.github_inspect_app.model.User

class UserListAdapter(
    var users: MutableList<User>
): RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    inner class UserListViewHolder(val binding: UserListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserListBinding.inflate(layoutInflater, parent, false)

        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.binding.apply {
            tvUserName.text = users[position].login ?: "undefined"
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsersList(users: List<User>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }
}