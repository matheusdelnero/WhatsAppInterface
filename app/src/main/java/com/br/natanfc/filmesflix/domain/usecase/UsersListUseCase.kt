package com.br.natanfc.filmesflix.domain.usecase

import com.br.natanfc.filmesflix.data.UserRepository

class UsersListUseCase(private val userRepository: UserRepository) {

    operator fun invoke() = userRepository.getAllUsersFromDataSource()

}