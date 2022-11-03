package com.ukm.iotsamplesubscriber.component

import android.os.CountDownTimer
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ukm.iotsamplesubscriber.model.CCTVonModel
import com.ukm.iotsamplesubscriber.model.SensorPIR
import kotlin.random.Random

class Lampu {
    class SensorPIRLampu (private val action: (Double) -> Unit) {
        val firestore = Firebase.firestore
        val historyRef = firestore.collection("SensorPIRLampuHistory")
        val CCTVonModelRef = firestore.collection("CCTV").document("CCTVonModel")
        lateinit var timer : CountDownTimer

        fun start() {
            timer = object: CountDownTimer(5000, 1000) {
                override fun onTick(p0: Long) {
                    val randomNumber = Random.nextDouble()
                    historyRef.add(SensorPIR(randomNumber))
                    action.invoke(randomNumber)
                }

                override fun onFinish() {
                    CCTVonModelRef.update("startTask", false)
                }
            }
            timer.start()
        }
    }
}