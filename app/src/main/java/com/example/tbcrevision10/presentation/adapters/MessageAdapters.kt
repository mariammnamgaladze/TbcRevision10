package com.example.tbcrevision10.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tbcrevision10.R
import com.example.tbcrevision10.data.model.Message
import com.example.tbcrevision10.databinding.ItemLayoutBinding
import com.example.tbcrevision10.extensions.setImage

class MessageAdapters : ListAdapter<Message.MessageItem, MessageAdapters.MyViewHolder>(object :
    DiffUtil.ItemCallback<Message.MessageItem>() {
    override fun areItemsTheSame(
        oldItem: Message.MessageItem,
        newItem: Message.MessageItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Message.MessageItem,
        newItem: Message.MessageItem
    ): Boolean {
        return oldItem == newItem
    }
}) {

    inner class MyViewHolder(val binding: ItemLayoutBinding) : ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            getItem(position).avatar?.let { iconImageView.setImage(it) }
            nameTV.text =
                getItem(position).firstName.toString() + getItem(position).lastName.toString()
            messageTV.text = getItem(position).lastMessage.toString()
            if (getItem(position).messageType == "attachment") {
                messageTV.text = "attachment has sent"
                iconImageView.setImageResource(R.drawable.attachment)
            } else if (getItem(position).messageType == "voice") {
                messageTV.text = "voice has sent"
                iconImageView.setImageResource(R.drawable.recorder)
            } else {
                messageTV.text = getItem(position).lastMessage
                iconImageView.visibility = View.GONE
            }
        }

    }
}
