package com.tcs.service.edt.model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.eventuate.tram.events.common.DomainEvent

class PreECMR: DomainEvent {

    var shipment_id: String = ""

    constructor() {}
    constructor(message: String) {
        this.shipment_id = message

    }
}