package com.benjamin.week6assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.benjamin.week6assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]


        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList) {
            val intent = Intent(this, ContactDisplayActivity2::class.java)
            intent.putExtra("fullName", it.fullName)
            intent.putExtra("phoneNum", it.phoneNum)
            intent.putExtra("email", it.email)
            startActivity(intent)
        }
        binding.recyclerView.adapter = myContactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()

        viewModel.getAllContactItems(db).observe(this, {

            myContactAdapter = ContactAdapter(it) {
                val intent = Intent(this, ContactDisplayActivity2::class.java)
                intent.putExtra("fullName", it.fullName)
                intent.putExtra("phoneNum", it.phoneNum)
                intent.putExtra("email", it.email)
                startActivity(intent)
            }

            binding.recyclerView.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()


        })
        binding.button.setOnClickListener {
            val fullName: String = binding.editText.text.toString()
            val phoneNum: String = binding.editText2.text.toString()
            val email: String = binding.editText3.text.toString()

            val contactItem = ContactModel(fullName, phoneNum, email)
            viewModel.addContactList(contactItem, db)
            myContactAdapter.notifyDataSetChanged()


        }
    }
}