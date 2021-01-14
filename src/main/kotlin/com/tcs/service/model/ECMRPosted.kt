package com.tcs.service.model

import javax.persistence.Id

data class ECMRPosted(

        @Id
//        var Message: Int,
//
//        var MessageCreationTimestamp: String,
        var ShipmentId: String = "",
//        var GlnShipFrom: String = "",
//        var GlnShipTo: String = "",
//        var JsonBody: String
)