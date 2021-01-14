package com.tcs.service.events

import io.eventuate.tram.events.common.DomainEvent

class ECMRPostedEvent: DomainEvent {

    var ShipmentId:String = ""
//    var MessageNo:String = ""

    constructor() {}
    constructor(message: String) {
        this.ShipmentId = message

    }
}