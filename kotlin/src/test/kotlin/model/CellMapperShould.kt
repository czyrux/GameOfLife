package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

internal class CellMapperShould {

    @Test
    fun mapToAliveStateWhenDot() {
        assertEquals(Cell.Alive, mapCell('.'))
    }

    @Test
    fun mapToDeadStateWhenAsterisk() {
        assertEquals(Cell.Dead, mapCell('*'))
    }

    @Test
    fun throwExceptionInOtherValue() {
        assertThrows(IllegalStateException::class.java) { mapCell('+') }
    }
}