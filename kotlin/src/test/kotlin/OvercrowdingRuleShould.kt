import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class OvercrowdingRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(OvercrowdingRule().apply(GameOfLifeCell.Dead, listOf()))
    }

    @Test
    fun applyWhenMoreThan3LivingNeighbours() {
        assertTrue(
            OvercrowdingRule().apply(
                GameOfLifeCell.Alive,
                listOf(GameOfLifeCell.Dead, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive)
            )
        )
    }

    @Test
    fun notBeAppliedWhenLessOr3LivingNeighbours() {
        assertAll(
            Executable {
                assertFalse(
                    OvercrowdingRule().apply(
                        GameOfLifeCell.Alive,
                        listOf(GameOfLifeCell.Dead, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive)
                    )
                )
            },
            Executable {
                assertFalse(
                    OvercrowdingRule().apply(
                        GameOfLifeCell.Alive,
                        listOf(GameOfLifeCell.Dead, GameOfLifeCell.Alive, GameOfLifeCell.Alive)
                    )
                )
            },
            Executable {
                assertFalse(
                    OvercrowdingRule().apply(
                        GameOfLifeCell.Alive,
                        listOf(GameOfLifeCell.Dead, GameOfLifeCell.Alive)
                    )
                )
            }
        )
    }
}