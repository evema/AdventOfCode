package Day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SpiralMemoryKtTest {

    @Test
    fun calculateItTest1() {
        assertEquals(0, calculateIt(1))
    }

    @Test
    fun calculateItTest23() {
        assertEquals(2, calculateIt(23))
    }

    @Test
    fun calculateItTest1024() {
        assertEquals(31, calculateIt(1024))
    }

    @Test
    fun calculateItTestAdventOfCode() {
        assertEquals(552, calculateIt(325489))
    }
}