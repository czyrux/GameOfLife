import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class RegenerateCellRuleShould {

    @Test
    fun notBeAppliedWithAliveCells() {
        assertFalse(RegenerateCellRule().apply(GameOfLifeCell.Alive, listOf()))
    }

    @Test
    fun applyWhen3AliveNeighbours() {
        assertTrue(
            RegenerateCellRule().apply(
                GameOfLifeCell.Dead,
                listOf(GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Dead)
            )
        )
    }

    @Test
    fun notApplyWhenLessThan3AliveNeighbours() {
        assertAll(
            Executable {
                assertFalse(
                    RegenerateCellRule().apply(
                        GameOfLifeCell.Dead,
                        listOf(GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Dead)
                    )
                )

            },
            Executable {
                assertFalse(
                    RegenerateCellRule().apply(
                        GameOfLifeCell.Dead,
                        listOf(GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Dead)
                    )
                )

            }
        )
    }
}