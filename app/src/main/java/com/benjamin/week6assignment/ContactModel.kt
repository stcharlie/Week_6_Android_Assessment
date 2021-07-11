package com.benjamin.week6assignment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactModel(
    val fullName: String,
    val phoneNum: String,
    val email : String,

    @PrimaryKey(autoGenerate = true)
    val uid :Int = 0
)
