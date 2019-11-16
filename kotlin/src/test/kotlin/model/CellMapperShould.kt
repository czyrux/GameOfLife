package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

internal class CellMapperShould {

    @Test
    fun mapToAliveStateWhenDot() {
        assertEquals(CellState.Alive, mapCellState('.'))
    }

    @Test
    fun mapToDeadStateWhenAsterisk() {
        assertEquals(CellState.Dead, mapCellState('*'))
    }

    @Test
    fun throwExceptionInOtherValue() {
        assertThrows(IllegalStateException::class.java) { mapCellState('+') }
    }
}