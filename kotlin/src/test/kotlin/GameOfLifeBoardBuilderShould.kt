import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.lang.IllegalStateException

internal class GameOfLifeBoardBuilderShould {

    @Test
    fun createBoardWithCellsInCorrectState() {
        val board: GameOfLifeBoard = GameOfLifeBoard.Builder().withRow(listOf(GameOfLifeCell.Dead, GameOfLifeCell.Alive)).build()
        assertAll(
            Executable { assertTrue(board.getCell(0, 0).isDead()) },
            Executable { assertTrue(board.getCell(0, 1).isAlive()) }
        )
    }

    @Test
    fun createBoardWithSingleRow() {
        val board: GameOfLifeBoard = GameOfLifeBoard.Builder().withRow(listOf(GameOfLifeCell.Dead)).build()
        assertEquals(1, board.getRows())
    }

    @Test
    fun createBoardWithMultipleRows() {
        val board: GameOfLifeBoard =
            GameOfLifeBoard.Builder()
                .withRow(listOf(GameOfLifeCell.Dead))
                .withRow(listOf(GameOfLifeCell.Alive))
                .build()
        assertEquals(2, board.getRows())
    }

    @Test
    fun allowBoardCreationWhenAllRowsContainSameAmountColumns() {
        val board: GameOfLifeBoard =
            GameOfLifeBoard.Builder()
                .withRow(listOf(GameOfLifeCell.Dead))
                .withRow(listOf(GameOfLifeCell.Alive))
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
                .withRow(listOf(GameOfLifeCell.Dead))
                .withRow(listOf(GameOfLifeCell.Alive, GameOfLifeCell.Dead))
                .build()
        }
    }
}