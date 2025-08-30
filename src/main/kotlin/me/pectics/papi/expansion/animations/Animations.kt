package me.pectics.papi.expansion.animations

fun chaos(prob: Double, mini: Boolean = true): String {
    return if (Math.random() > prob) "" else if (mini) "<obf>" else "§k"
}