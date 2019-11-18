import model.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class OvercrowdingRuleShould {

    @Test
    fun notBeAppliedWithDeadCells() {
        assertFalse(OvercrowdingRule().apply(Cell.Dead, listOf()))
    }

    @Test
    fun applyWhenMoreThan3LivingNeighbours() {
        assertTrue(
            OvercrowdingRule().apply(
                Cell.Alive,
                listOf(Cell.Dead, Cell.Alive, Cell.Alive, Cell.Alive, Cell.Alive)
            )
        )
    }

    @Test
    fun notBeAppliedWhenLessOr3LivingNeighbours() {
        assertAll(
            Executable {
                assertFalse(
                    OvercrowdingRule().apply(
                        Cell.Alive,
                        listOf(Cell.Dead, Cell.Alive, Cell.Alive, Cell.Alive)
                    )
                )
            },
            Executable {
                assertFalse(
                    OvercrowdingRule().apply(
                        Cell.Alive,
                        listOf(Cell.Dead, Cell.Alive, Cell.Alive)
                    )
                )
            },
            Executable {
                assertFalse(
                    OvercrowdingRule().apply(
                        Cell.Alive,
                        listOf(Cell.Dead, Cell.Alive)
                    )
                )
            }
        )
    }
}