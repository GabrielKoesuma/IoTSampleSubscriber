package com.ukm.iotsamplesubscriber.model

import com.google.firebase.firestore.PropertyName

data class SensorPIR(
    @PropertyName("SensorPIR")
    val SensorPIR: Double = 0.0

) {
}
