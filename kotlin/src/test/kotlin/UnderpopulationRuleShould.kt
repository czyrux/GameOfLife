import model.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UnderpopulationRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(UnderpopulationRule().apply(Cell.Dead, listOf()))
    }

    @Test
    fun applyWhenLessThanTwoLiveNeighbours() {
        assertTrue(
            UnderpopulationRule().apply(
                Cell.Alive,
                listOf(Cell.Dead, Cell.Dead, Cell.Alive)
            )
        )
    }

    @Test
    fun notApplyWhenMoreThanTwoLiveNeighbours() {
        assertFalse(
            UnderpopulationRule().apply(
                Cell.Alive,
                listOf(Cell.Dead, Cell.Alive, Cell.Alive)
            )
        )
    }
}