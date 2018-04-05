package Day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReallocationRoutineKtTest {

    @Test
    fun countStepsToCycleTest() {
        assertEquals(5, countStepsToCycle("0\t2\t7\t0"))
    }

    @Test
    fun countStepsToCycleTestAdventOfCode() {
        assertEquals(5042, countStepsToCycle("5\t1\t10\t0\t1\t7\t13\t14\t3\t12\t8\t10\t7\t12\t0\t6"))
    }

    @Test
    fun countStepsOfEndlessLoop() {
        assertEquals(4, countStepsOfEndlessLoop("0\t2\t7\t0"))
    }

    @Test
    fun countStepsOfEndlessLoopAdventOfCode() {
        assertEquals(1086, countStepsOfEndlessLoop("5\t1\t10\t0\t1\t7\t13\t14\t3\t12\t8\t10\t7\t12\t0\t6"))
    }
}