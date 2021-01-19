package com.tcs.service.service

import com.tcs.service.constant.URLPath.AUTH_URI
import com.tcs.service.model.AuthCode
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import java.nio.charset.StandardCharsets
import org.apache.logging.log4j.kotlin.logger

@Service
class Auth(private val restTemplate: RestTemplate) {

    fun authCode(): String? {

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        headers.acceptCharset = mutableListOf(StandardCharsets.UTF_8)

        val logger = logger()

        println("after content type")

        val map: LinkedMultiValueMap<String, String> = LinkedMultiValueMap()
        map.add("grant_type", "client_credentials")
        map.add("client_id", "76c9a1a9-f1fb-4a73-a0c6-4fc43afd808d")
        map.add("scope", "api://adde9385-2a45-4487-a17e-9ba7414e0261/.default")
        map.add("client_secret", "8V4VpBQ_Xyp_PgJNEv~7sq3ElB3R55tm-o")

        val entity = HttpEntity(map, headers)

        logger.info("Before")
        val response = restTemplate.exchange(AUTH_URI,
                HttpMethod.POST, entity, AuthCode::class.java)

        logger.info("After")

        println(response.body?.access_token)

        return response.body?.access_token
    }
}