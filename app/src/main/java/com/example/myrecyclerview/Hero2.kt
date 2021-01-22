package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class Hero2 (s: String, s1: String, s2: String, ) {

    @Parcelize
    data class Heroes(
        var name: String,
        val description: String,
        var photo: String
    ) : Parcelable

}