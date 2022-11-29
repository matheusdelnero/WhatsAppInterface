package com.br.natanfc.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.api.UserRestApiTask
import com.br.natanfc.filmesflix.data.UserRepository
import com.br.natanfc.filmesflix.domain.Users
import com.br.natanfc.filmesflix.presenter.implementation.UserDataSourceImplementation
import com.br.natanfc.filmesflix.domain.usecase.UsersListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserListViewModel() :ViewModel() {


    private val userRestApiTask = UserRestApiTask()
    private val userDataSource = UserDataSourceImplementation(userRestApiTask)
    private val userRepository = UserRepository(userDataSource)
    private val usersListUseCase = UsersListUseCase(userRepository)

    companion object {
        const val TAG = "UserRepository"
    }




    private var _usersList = MutableLiveData<List<Users>>()
    val usersList: LiveData<List<Users>>
        get() = _usersList

    fun init() {
        getAllUsers()
    }

    fun getAllUsers() {
        GlobalScope.launch(Dispatchers.IO){

            try {
                _usersList.postValue(usersListUseCase.invoke())

            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }
    }
}