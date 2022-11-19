package com.br.natanfc.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.br.natanfc.filmesflix.domain.Users
import com.br.natanfc.filmesflix.framework.viewmodel.UserListViewModel
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private lateinit var userListViewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userListViewModel = ViewModelProvider.NewInstanceFactory().create(UserListViewModel::class.java)
        userListViewModel.init()
        initObserver()
        loadingVisibility(true)

    }

    private fun initObserver() {
        userListViewModel.usersList.observe(this, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Users>) {
        usersList.apply {
            hasFixedSize()
            adapter = UsersAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}