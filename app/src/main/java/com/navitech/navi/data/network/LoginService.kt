package com.navitech.navi.data.network

import com.androidnetworking.interfaces.ParsedRequestListener
import com.navitech.navi.data.model.BaseResponse
import com.navitech.navi.data.model.LoginModel

object LoginService {

    fun login(request: LoginModel, call: ParsedRequestListener<BaseResponse>) {
        //  TODO Connection with server
        if (request.email == "jordi933@gmail.com" && request.password == "abcd1234") {
            call.onResponse(BaseResponse("success", 200, Object()))
        }
    }
}