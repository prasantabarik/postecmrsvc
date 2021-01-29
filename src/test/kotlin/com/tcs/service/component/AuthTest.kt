package com.tcs.service.component

import com.tcs.service.constant.URLPath
import com.tcs.service.service.Auth
import com.tcs.service.utility.Utility
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate
import java.util.stream.Collectors

class AuthTest {

  //  @Autowired
//    lateinit
var restTemplate: RestTemplate = RestTemplate()

    var auth: Auth = Auth(restTemplate)

    @Test
    fun prepareAuthTest() {

        val result = auth.authCode()

        Assert.assertNotNull(result)

    }
}