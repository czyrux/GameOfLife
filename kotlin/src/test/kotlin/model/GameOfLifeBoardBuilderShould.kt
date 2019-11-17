package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

internal class GameOfLifeBoardBuilderShould {
    @Test
    fun createBoardWithSingleRow() {
        var board: GameOfLifeBoard = GameOfLifeBoard.Builder().withRow(listOf(Cell(CellState.Dead))).build()
        assertEquals(1, board.getRows())
    }

    @Test
    fun createBoardWithMultipleRows() {
        var board: GameOfLifeBoard =
            GameOfLifeBoard.Builder()
                .withRow(listOf(Cell(CellState.Dead)))
                .withRow(listOf(Cell(CellState.Alive)))
                .build()
        assertEquals(2, board.getRows())
    }

    @Test
    fun allowBoardCreationWhenAllRowsContainSameAmountColumns() {
        var board: GameOfLifeBoard =
            GameOfLifeBoard.Builder()
                .withRow(listOf(Cell(CellState.Dead)))
                .withRow(listOf(Cell(CellState.Alive)))
                .build()
        assertEquals(1, board.getColumns())
    }

    @Test
    fun throwWhenNoRows() {
        assertThrows(IllegalStateException::class.java) {
            GameOfLifeBoard.Builder().build()
        }
    }

    @Test
    fun throwWhenRowsHaveDifferentColumns() {
        assertThrows(IllegalStateException::class.java) {
            GameOfLifeBoard.Builder()
                .withRow(listOf(Cell(CellState.Dead)))
                .withRow(listOf(Cell(CellState.Alive), Cell(CellState.Dead)))
                .build()
        }
    }
}