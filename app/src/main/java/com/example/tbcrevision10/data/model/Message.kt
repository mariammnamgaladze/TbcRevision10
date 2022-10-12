package com.example.tbcrevision10.data.model

import com.squareup.moshi.Json

data class Message(val messageItem: List<MessageItem>) {
    data class MessageItem(
        val avatar: String?,
        @Json(name = "first_name")
        val firstName: String?,
        val id: Int?,
        @Json(name = "is_typing")
        val isTyping: Boolean?,
        @Json(name = "last_message")
        val lastMessage: String?,
        @Json(name = "last_name")
        val lastName: String?,
        @Json(name = "message_type")
        val messageType: String?,
        @Json(name = "unrea_message")
        val unreaMessage: Int?,

        )
}