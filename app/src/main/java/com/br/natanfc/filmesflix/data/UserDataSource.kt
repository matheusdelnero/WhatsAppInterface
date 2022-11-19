package com.br.natanfc.filmesflix.data

import com.br.natanfc.filmesflix.domain.Users

interface UserDataSource {

    fun getAllUsers(): List<Users>

}