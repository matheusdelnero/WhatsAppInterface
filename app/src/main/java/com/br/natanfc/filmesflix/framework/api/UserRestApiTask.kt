package com.br.natanfc.filmesflix.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class UserRestApiTask {

    companion object {
        const val BASE_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    }

    private fun userProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): UserApi = userProvider().create(UserApi::class.java)

}