import util.createSampleBoardGen1
import util.createSampleBoardGen2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GameOfLifeShould {
    @Test
    fun playOneRoundOfTheGame() {
        val board = createSampleBoardGen1()

        val finalBoard = playGame(initialBoard = board, generations = 1)

        assertEquals(createSampleBoardGen2(), finalBoard)
    }
}
