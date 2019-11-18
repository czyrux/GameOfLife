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
                Cell.Dead, Cell.Alive, Cell.Dead,
                Cell.Alive, Cell.Alive,
                Cell.Dead, Cell.Alive, Cell.Dead
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
                Cell.Dead, Cell.Dead,
                Cell.Alive, Cell.Dead, Cell.Alive
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
                Cell.Alive, Cell.Dead, Cell.Alive,
                Cell.Dead, Cell.Dead
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
                Cell.Alive,
                Cell.Alive, Cell.Dead
            ),
            neighbours
        )
    }

    private fun getSampleBoard() = GameOfLifeBoard.Builder()
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Alive,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Alive,
                Cell.Dead,
                Cell.Alive
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Alive,
                Cell.Dead
            )
        )
        .build()
}