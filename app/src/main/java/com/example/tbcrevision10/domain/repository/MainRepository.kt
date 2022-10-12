package com.example.tbcrevision10.domain.repository

import com.example.tbcrevision10.data.common.ResponseHandler
import com.example.tbcrevision10.data.model.Message
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getMessages(): Flow<ResponseHandler<List<Message.MessageItem>>>
}