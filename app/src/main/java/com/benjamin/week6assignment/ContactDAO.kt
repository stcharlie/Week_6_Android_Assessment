package com.benjamin.week6assignment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {
    @Insert
    fun addContactList(contactItem :ContactModel)

    @Query("SELECT * from contactmodel")
    fun getAllContactItem(): LiveData<List<ContactModel>>

    @Delete
    fun delete(contactItem:ContactModel)
}