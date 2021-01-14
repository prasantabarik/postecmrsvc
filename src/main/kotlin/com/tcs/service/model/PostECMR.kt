package com.tcs.service.model

import javax.persistence.*

//@Entity
//@Table(name="ecmr")
//@org.springframework.data.relational.core.mapping.Table
data class PostECMR(
    @Id
    var ShipmentId: String = ""
)