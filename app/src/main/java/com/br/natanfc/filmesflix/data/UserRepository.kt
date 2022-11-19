package com.br.natanfc.filmesflix.data

class UserRepository(private val userDataSource: UserDataSource) {

    fun getAllUsersFromDataSource() = userDataSource.getAllUsers()

}