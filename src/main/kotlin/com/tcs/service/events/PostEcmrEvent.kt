package com.tcs.service.events

import io.eventuate.tram.events.common.DomainEvent
import org.springframework.data.domain.DomainEvents

class PostEcmrEvent : DomainEvent {

    var ShipmentId:String = ""
//    var MessageNo:String = ""

    constructor() {}
    constructor(message: String) {
        this.ShipmentId = message

    }
}

