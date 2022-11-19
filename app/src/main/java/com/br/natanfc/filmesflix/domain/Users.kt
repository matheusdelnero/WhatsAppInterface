package com.br.natanfc.filmesflix.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users(
    val id: Int,
    val name: String,
    val img: String?,
    val username: String?
): Parcelable