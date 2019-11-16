package model

data class Cell(val state: CellState) {
    fun isAlive()= state == CellState.Alive
    fun isDead() = state == CellState.Dead
}