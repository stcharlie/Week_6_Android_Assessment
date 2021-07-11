package com.benjamin.week6assignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benjamin.week6assignment.databinding.ContactListsItemBinding

class ContactAdapter (
    val contactList: List<ContactModel>,val clickerFxn:(ContactModel)-> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ContactListsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contactList: ContactModel) {
            binding.fullName.text = contactList.fullName
            binding.phoneNum.text = contactList.phoneNum
            binding.email.text = contactList.email
            binding.root.setOnClickListener{
                clickerFxn(contactList)

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val binding: ContactListsItemBinding =
            ContactListsItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
        holder.bind(contactList.get(position))
    }

    override fun getItemCount() = contactList.size




}