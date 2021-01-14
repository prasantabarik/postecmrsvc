package com.tcs.service.controller

//import com.tcs.service.DAO.ShipS
import com.tcs.service.model.ECMRPosted
import com.tcs.service.model.PostECMR
import com.tcs.service.service.Producer
//import com.tcs.service.repos.OracleInterface
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class Controller(
private val producer: Producer ) {


    @RequestMapping("/post",method = [RequestMethod.POST])
    fun create(@RequestBody posted: ECMRPosted) {

   var create = producer.create(posted)

    }
}