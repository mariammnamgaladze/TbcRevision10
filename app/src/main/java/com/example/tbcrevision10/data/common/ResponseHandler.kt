package com.example.tbcrevision10.data.common

import com.example.tbcrevision10.data.model.Message


sealed class ResponseHandler<T>( val isLoading:Boolean){
    class Success<T> (val response:T):ResponseHandler<T>(false)
    class Error<T> ( val errorResponse:String):ResponseHandler<T>(false)
    class InProcess<T> ():ResponseHandler<T>(true)
}
