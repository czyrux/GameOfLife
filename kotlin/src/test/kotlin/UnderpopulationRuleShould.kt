import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UnderpopulationRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(UnderpopulationRule().apply(GameOfLifeCell.Dead, listOf()))
    }

    @Test
    fun applyWhenLessThanTwoLiveNeighbours() {
        assertTrue(
            UnderpopulationRule().apply(
                GameOfLifeCell.Alive,
                listOf(GameOfLifeCell.Dead, GameOfLifeCell.Dead, GameOfLifeCell.Alive)
            )
        )
    }

    @Test
    fun notApplyWhenMoreThanTwoLiveNeighbours() {
        assertFalse(
            UnderpopulationRule().apply(
                GameOfLifeCell.Alive,
                listOf(GameOfLifeCell.Dead, GameOfLifeCell.Alive, GameOfLifeCell.Alive)
            )
        )
    }
}