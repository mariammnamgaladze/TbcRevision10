package com.example.tbcrevision10.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tbcrevision10.data.common.ResponseHandler
import com.example.tbcrevision10.data.model.Message
import com.example.tbcrevision10.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel() {

    private val _messageFlow = MutableSharedFlow<ResponseHandler<List<Message.MessageItem>>>()
    val messageFlow get() = _messageFlow.asSharedFlow()


    suspend fun getMessages() {
        mainRepository.getMessages()
            .collect {
                _messageFlow.emit(it)
            }
    }
}