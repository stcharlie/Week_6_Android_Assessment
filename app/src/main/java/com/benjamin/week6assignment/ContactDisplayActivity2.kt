package com.benjamin.week6assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benjamin.week6assignment.databinding.ActivityContactDisplay2Binding

class ContactDisplayActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityContactDisplay2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactDisplay2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstDis.text = intent.getStringExtra("fullName")
        binding.firstDis2.text = intent.getStringExtra("phoneNum")
        binding.firstDis3.text = intent.getStringExtra("email")
    }
}