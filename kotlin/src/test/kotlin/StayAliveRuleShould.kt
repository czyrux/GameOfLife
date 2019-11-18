import model.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class StayAliveRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(StayAliveRule().apply(Cell.Dead, listOf()))
    }

    @Test
    fun applyWhen2AliveNeighbours() {
        assertTrue(StayAliveRule().apply(Cell.Alive, listOf(Cell.Alive, Cell.Alive, Cell.Dead, Cell.Dead)))
    }

    @Test
    fun applyWhen3AliveNeighbours() {
        assertTrue(StayAliveRule().apply(Cell.Alive, listOf(Cell.Alive, Cell.Alive, Cell.Alive, Cell.Dead, Cell.Dead)))
    }

    @Test
    fun notApplyWhen1AliveNeighbours() {
        assertFalse(StayAliveRule().apply(Cell.Alive, listOf(Cell.Alive, Cell.Dead, Cell.Dead)))
    }

    @Test
    fun notApplyWhenMoreThan3AliveNeighbours() {
        assertAll(
            Executable {
                assertFalse(StayAliveRule().apply(Cell.Alive, listOf(Cell.Alive, Cell.Alive, Cell.Alive, Cell.Alive)))
            },
            Executable {
                assertFalse(
                    StayAliveRule().apply(
                        Cell.Alive,
                        listOf(Cell.Alive, Cell.Alive, Cell.Alive, Cell.Alive, Cell.Alive)
                    )
                )
            }
        )
    }
}