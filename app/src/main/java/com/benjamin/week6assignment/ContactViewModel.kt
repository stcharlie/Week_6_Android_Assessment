package com.benjamin.week6assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {
    fun addContactList(
        contactItem: ContactModel,
        database: ContactDatabase
    ) {
        database.contactDao().addContactList(contactItem)
    }


    fun getAllContactItems(database: ContactDatabase): LiveData<List<ContactModel>> {
        return database.contactDao().getAllContactItem()
    }
}
