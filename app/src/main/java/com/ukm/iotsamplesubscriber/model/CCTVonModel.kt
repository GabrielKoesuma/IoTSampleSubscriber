package com.ukm.iotsamplesubscriber.model

import com.google.firebase.firestore.PropertyName

data class CCTVonModel(
    @PropertyName("startTask")
    val startTask: Boolean = false
)
