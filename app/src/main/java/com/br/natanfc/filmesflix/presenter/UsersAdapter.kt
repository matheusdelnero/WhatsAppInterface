package com.br.natanfc.filmesflix

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.br.natanfc.filmesflix.domain.Users
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class UsersAdapter(private val userList: List<Users>): RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.itemView.apply {
            userTitle.text = userList[position].name
            userTitle2.text = userList[position].username
            userImage.load(userList[position].img) {
                placeholder(R.drawable.usuario)
                fallback(R.drawable.usuario)
            }
        }
    }

    override fun getItemCount(): Int = userList.size
}