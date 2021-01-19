package com.tcs.service.model

data class AuthCode (

        val token_type: String = "",
        val expires_in: String,
        val ext_expires_in: String,
        val access_token: String
)

