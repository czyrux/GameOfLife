import model.Cell
import model.createSampleBoardGen1
import model.createSampleBoardGen2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GameOfLifePlayTest {
    @Test
    fun playGame() {
        val board = createSampleBoardGen1()

        val finalBoard = playGame(initialBoard = board, generations = 1)

        assertEquals(createSampleBoardGen2(), finalBoard)
    }
}
