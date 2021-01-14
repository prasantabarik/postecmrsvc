package com.tcs.service.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document(collection = "ecmr")
data class ECMR (

        var shipmentId: String = "",
        var messageNo: String = "",
        var messageCreationDateTime: String = "",
        var testIndicator: String = "",
        var glnShipFrom: String = "",
        var glnShipTo: String = "",
        var referenceNumberOfTrip: String = "",
        var yearOfTrip: String = "",
        var finishedLoadingDateTime: String = "",
        var freightDocumentId: String = "",
        var arcCode: String = "" ,
        var arcCodeNeeded: Boolean = false,
        var orderInShipment: List<OrderInShipment> = listOf()
)
