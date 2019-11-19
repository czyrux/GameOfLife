package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

internal class CellMapperShould {

    @Test
    fun mapToDeadStateWhenDot() {
        assertEquals(Cell.Dead, mapCell('.'))
    }

    @Test
    fun mapToAliveStateWhenAsterisk() {
        assertEquals(Cell.Alive, mapCell('*'))
    }

    @Test
    fun throwExceptionInOtherValue() {
        assertThrows(IllegalStateException::class.java) { mapCell('+') }
    }
}