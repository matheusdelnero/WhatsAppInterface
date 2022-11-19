package com.br.natanfc.filmesflix.api

import com.br.natanfc.filmesflix.domain.Users
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    //https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/users

    @GET("users")
    fun getAllUsers(): Call<List<Users>>
}