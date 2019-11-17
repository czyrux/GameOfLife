package model

import java.lang.IllegalStateException

sealed class CellState {
    object Dead : CellState()
    object Alive : CellState()
}

fun mapCellState(value: Char) = when (value) {
    '.' -> CellState.Alive
    '*' -> CellState.Dead
    else -> throw IllegalStateException("Unrecognized value: $value")
}