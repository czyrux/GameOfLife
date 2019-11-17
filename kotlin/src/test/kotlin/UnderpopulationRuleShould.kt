import model.Cell
import model.CellState
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UnderpopulationRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(UnderpopulationRule().apply(Cell(CellState.Dead), listOf()))
    }

    @Test
    fun applyWhenLessThanTwoLiveNeighbours() {
        assertTrue(
            UnderpopulationRule().apply(
                Cell(CellState.Alive),
                listOf(Cell(CellState.Dead), Cell(CellState.Dead), Cell(CellState.Alive))
            )
        )
    }

    @Test
    fun notApplyWhenMoreThanTwoLiveNeighbours() {
        assertFalse(
            UnderpopulationRule().apply(
                Cell(CellState.Alive),
                listOf(Cell(CellState.Dead), Cell(CellState.Alive), Cell(CellState.Alive))
            )
        )
    }
}