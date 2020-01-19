import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GameOfLifeBoardShould {

    @Test
    fun getAllNeighboursAroundCellWhenInTheMiddle() {
        val board = getSampleBoard()

        val neighbours = board.getNeighbours(row = 1, column = 1)

        assertEquals(8, neighbours.size)
        assertEquals(
            listOf(
                GameOfLifeCell.Dead, GameOfLifeCell.Alive, GameOfLifeCell.Dead,
                GameOfLifeCell.Alive, GameOfLifeCell.Alive,
                GameOfLifeCell.Dead, GameOfLifeCell.Alive, GameOfLifeCell.Dead
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
                GameOfLifeCell.Dead, GameOfLifeCell.Dead,
                GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Alive
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
                GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Alive,
                GameOfLifeCell.Dead, GameOfLifeCell.Dead
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
                GameOfLifeCell.Alive,
                GameOfLifeCell.Alive, GameOfLifeCell.Dead
            ),
            neighbours
        )
    }

    @Test
    fun getAllNeighboursAroundCellWhenInTopCornerRight() {
        val board = getSampleBoard()

        val neighbours = board.getNeighbours(row = 0, column = board.getColumns() - 1)

        assertEquals(3, neighbours.size)
        assertEquals(
            listOf(
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead, GameOfLifeCell.Alive
            ),
            neighbours
        )
    }

    private fun getSampleBoard() = GameOfLifeBoard.Builder()
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead
            )
        )
        .build()
}