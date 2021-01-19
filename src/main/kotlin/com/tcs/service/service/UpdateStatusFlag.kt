package com.tcs.service.service

import com.tcs.service.constant.URLPath.API_AUTH_URI
import com.tcs.service.constant.URLPath.API_URI
import com.tcs.service.constant.URLPath.PUT_URI
import com.tcs.service.model.ECMR
import com.tcs.service.model.ServiceResponse
import org.apache.logging.log4j.kotlin.logger
import org.springframework.stereotype.Service
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import java.util.logging.Logger

@Service
class UpdateStatusFlag(private val restTemplate: RestTemplate, private val auth: Auth) {

    fun changeFlag(ecmr: MutableList<ECMR>?){

        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType.APPLICATION_JSON
        httpHeaders.set("Authorization","Bearer " + auth.authCode())


        val logger = logger()
        println(httpHeaders)

        if (ecmr != null) {

            for(i in 0 until ecmr.size){

                val httpEntity = HttpEntity<ECMR>(ecmr[i], httpHeaders)
                logger.info("Before Post API")

                val flag = restTemplate.exchange(API_AUTH_URI, HttpMethod.POST, httpEntity, ServiceResponse::class.java)
//                val flag = restTemplate.exchange(API_URI, HttpMethod.POST, httpEntity, ServiceResponse::class.java)

                logger.info("After Post API")

                if (flag.statusCodeValue == 202){
                    ecmr[i].statusFlag = "Posted"
                    restTemplate.exchange(PUT_URI, HttpMethod.PUT, httpEntity, ServiceResponse::class.java)
                }else{
                    ecmr[i].statusFlag = "Not Posted"
                    restTemplate.exchange(PUT_URI, HttpMethod.PUT, httpEntity, ServiceResponse::class.java)
                }

            }
        }

    }


}