package com.example.tbcrevision10.data.repository

import com.example.tbcrevision10.data.common.ResponseHandler
import com.example.tbcrevision10.data.model.Message
import com.example.tbcrevision10.data.network.ApiCall
import com.example.tbcrevision10.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl@Inject constructor(private val messageApi: ApiCall):MainRepository {
    override suspend fun getMessages(): Flow<ResponseHandler<List<Message.MessageItem>>> {
        return flow {
            emit(ResponseHandler.InProcess())
            val response = messageApi.getApi()
            if (response.isSuccessful && response.body() != null) {
                emit(ResponseHandler.Success(response.body()!!))
            } else
                emit(ResponseHandler.Error("Error"))

        }
    }
}