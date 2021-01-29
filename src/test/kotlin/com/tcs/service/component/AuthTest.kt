package com.tcs.service.component

import com.tcs.service.constant.URLPath
import com.tcs.service.events.PostEcmrEvent
import com.tcs.service.model.ContainerInShipItems
import com.tcs.service.model.ECMR
import com.tcs.service.model.OrderInShipment
import com.tcs.service.model.ShipUnit
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
    @Test
    fun testModels() {
       val model1: ECMR = ECMR()
        val model2: OrderInShipment = OrderInShipment()
         val model3: ShipUnit = ShipUnit()
        val model4: ContainerInShipItems = ContainerInShipItems()
        val model5 : PostEcmrEvent = PostEcmrEvent()
    }
}