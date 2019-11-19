package model

import java.lang.IllegalStateException

sealed class Cell {
    object Alive : Cell()
    object Dead : Cell()
}

fun mapCell(value: Char) = when (value) {
    '.' -> Cell.Dead
    '*' -> Cell.Alive
    else -> throw IllegalStateException("Unrecognized value: $value")
}

fun Cell.isAlive() = this == Cell.Alive
fun Cell.isDead() = this == Cell.Dead