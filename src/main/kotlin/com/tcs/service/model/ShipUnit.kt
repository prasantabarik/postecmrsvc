package com.tcs.service.model

data class ShipUnit(
        var containerTypeGtinPrimaryContainer: String,
        var shipUnitSscc: String,
        var numberOfPrimaryContainers: String,
        var totalLoadWeight: Double
) {
}