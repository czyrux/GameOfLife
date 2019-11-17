package model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GameOfLifeBoardShould {

    @Test
    fun getAllNeighboursAroundCellWhenInTheMiddle() {
        val board = getSampleBoard()

        val neighbours = board.getNeighbours(row = 1, column = 1)

        assertEquals(8, neighbours.size)
        assertEquals(
            listOf(
                Cell(CellState.Dead), Cell(CellState.Alive), Cell(CellState.Dead),
                Cell(CellState.Alive), Cell(CellState.Alive),
                Cell(CellState.Dead), Cell(CellState.Alive), Cell(CellState.Dead)
            ),
            neighbours
        )
    }

    @Test
    fun getAllNeighboursAroundCellWhenInTopRow() {
        val board = getSampleBoard()

        val neighbours = board.getNeighbours(row = 0, column = 1)

        assertEquals(5, neighbours.size)
        assertEquals(
            listOf(
                Cell(CellState.Dead), Cell(CellState.Dead),
                Cell(CellState.Alive), Cell(CellState.Dead), Cell(CellState.Alive)
            ),
            neighbours
        )
    }

    @Test
    fun getAllNeighboursAroundCellWhenInBottomRow() {
        val board = getSampleBoard()

        val neighbours = board.getNeighbours(row = 2, column = 1)

        assertEquals(5, neighbours.size)
        assertEquals(
            listOf(
                Cell(CellState.Alive), Cell(CellState.Dead), Cell(CellState.Alive),
                Cell(CellState.Dead), Cell(CellState.Dead)
            ),
            neighbours
        )
    }

    @Test
    fun getAllNeighboursAroundCellWhenInCorner() {
        val board = getSampleBoard()

        val neighbours = board.getNeighbours(row = 0, column = 0)

        assertEquals(3, neighbours.size)
        assertEquals(
            listOf(
                Cell(CellState.Alive),
                Cell(CellState.Alive), Cell(CellState.Dead)
            ),
            neighbours
        )
    }

    private fun getSampleBoard() = GameOfLifeBoard.Builder()
        .withRow(
            listOf(
                CellState.Dead,
                CellState.Alive,
                CellState.Dead
            )
        )
        .withRow(
            listOf(
                CellState.Alive,
                CellState.Dead,
                CellState.Alive
            )
        )
        .withRow(
            listOf(
                CellState.Dead,
                CellState.Alive,
                CellState.Dead
            )
        )
        .build()
}