import model.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class RegenerateCellRuleShould {

    @Test
    fun notBeAppliedWithAliveCells() {
        assertFalse(RegenerateCellRule().apply(Cell.Alive, listOf()))
    }

    @Test
    fun applyWhen3AliveNeighbours() {
        assertTrue(
            RegenerateCellRule().apply(
                Cell.Dead,
                listOf(Cell.Alive, Cell.Alive, Cell.Alive, Cell.Dead, Cell.Dead)
            )
        )
    }

    @Test
    fun notApplyWhenLessThan3AliveNeighbours() {
        assertAll(
            Executable {
                assertFalse(
                    RegenerateCellRule().apply(
                        Cell.Dead,
                        listOf(Cell.Alive, Cell.Dead, Cell.Dead)
                    )
                )

            },
            Executable {
                assertFalse(
                    RegenerateCellRule().apply(
                        Cell.Dead,
                        listOf(Cell.Alive, Cell.Alive, Cell.Dead, Cell.Dead)
                    )
                )

            }
        )
    }
}