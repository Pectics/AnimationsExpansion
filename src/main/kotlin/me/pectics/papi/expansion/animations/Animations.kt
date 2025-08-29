package me.pectics.papi.expansion.animations

fun chaos(prob: Double): String {
    return if (Math.random() > prob) "" else "§k"
}