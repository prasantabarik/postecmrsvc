package com.tcs.service.component

import com.tcs.service.events.ECMRPostedEvent
import com.tcs.service.events.PostEcmrEvent
import com.tcs.service.model.*
import com.tcs.service.service.Auth
import com.tcs.service.service.UpdateStatusFlag
import org.junit.Assert
import org.junit.Test
import org.springframework.web.client.RestTemplate

class AuthTest {

  //  @Autowired
//    lateinit
var restTemplate: RestTemplate = RestTemplate()

    var auth: Auth = Auth(restTemplate)

    var updateStatus: UpdateStatusFlag= UpdateStatusFlag(restTemplate,auth)

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
        val model9: AuthCode = AuthCode()
        val model6: ECMRPosted = ECMRPosted()
         val model7: ECMRPostedEvent = ECMRPostedEvent()
        val model8: ServiceResponse = ServiceResponse()
    }

    @Test
    fun testFlag() {
       var ecmr: MutableList<ECMR> = mutableListOf()
        updateStatus.changeFlag(ecmr)
    }
}