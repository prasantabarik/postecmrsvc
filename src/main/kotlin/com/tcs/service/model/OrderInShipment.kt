package com.tcs.service.model

data class OrderInShipment(
        var referenceNumberPointOfDeparture: String,
        var shipUnit: List<ShipUnit>
) {
}