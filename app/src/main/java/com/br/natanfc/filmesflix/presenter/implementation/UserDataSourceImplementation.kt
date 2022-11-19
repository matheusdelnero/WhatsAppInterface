package com.br.natanfc.filmesflix.presenter.implementation

import android.util.Log
import com.br.natanfc.filmesflix.api.UserRestApiTask
import com.br.natanfc.filmesflix.data.UserDataSource
import com.br.natanfc.filmesflix.domain.Users

class UserDataSourceImplementation(private val userRestApiTask: UserRestApiTask): UserDataSource {

    companion object {
        const val TAG = "UserRepository"
    }


    private val userList = arrayListOf<Users>()

    override fun getAllUsers(): List<Users> {
        val request =  userRestApiTask.retrofitApi().getAllUsers().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                userList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }

        return userList
    }
}