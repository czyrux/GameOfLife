import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class StayAliveRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(StayAliveRule().apply(GameOfLifeCell.Dead, listOf()))
    }

    @Test
    fun applyWhen2AliveNeighbours() {
        assertTrue(StayAliveRule().apply(GameOfLifeCell.Alive, listOf(GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Dead)))
    }

    @Test
    fun applyWhen3AliveNeighbours() {
        assertTrue(StayAliveRule().apply(GameOfLifeCell.Alive, listOf(GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Dead)))
    }

    @Test
    fun notApplyWhen1AliveNeighbours() {
        assertFalse(StayAliveRule().apply(GameOfLifeCell.Alive, listOf(GameOfLifeCell.Alive, GameOfLifeCell.Dead, GameOfLifeCell.Dead)))
    }

    @Test
    fun notApplyWhenMoreThan3AliveNeighbours() {
        assertAll(
            Executable {
                assertFalse(StayAliveRule().apply(GameOfLifeCell.Alive, listOf(GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive)))
            },
            Executable {
                assertFalse(
                    StayAliveRule().apply(
                        GameOfLifeCell.Alive,
                        listOf(GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive, GameOfLifeCell.Alive)
                    )
                )
            }
        )
    }
}