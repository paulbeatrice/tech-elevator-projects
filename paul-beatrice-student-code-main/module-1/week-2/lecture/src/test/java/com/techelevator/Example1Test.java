package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example1Test {

    private final Example1 sut = new Example1();

    @Test
    public void testSumAllNumbers() {
        assertEquals(1, sut.sumAllNumbers(0, 1), "sumAllNumbers(0, 1)");
        assertEquals(20, sut.sumAllNumbers(2, 6), "sumAllNumbers(2, 6)");
        assertEquals(510, sut.sumAllNumbers(100, 104), "sumAllNumbers(100, 104)");
    }

    @Test
    public void testArrayFront9() {
        assertEquals(true, sut.arrayFront9(new int[] {1, 9, 2}), "arrayFront9(1, 9, 2)");
        assertEquals(false, sut.arrayFront9(new int[] {1, 2, 3, 4, 9}), "arrayFront9(1, 2, 3, 4, 9)");
        assertEquals(false, sut.arrayFront9(new int[] {1, 2, 3, 4, 5}), "arrayFront9(1, 2, 3, 4, 5)");
    }

    @Test
    public void testHalveAll() {
        assertArrayEquals(new double[] {1.0, 2.0, 3.0, 4.0}, sut.halveAll(new int[] {2, 4, 6, 8}), 0.01, "halveAll([2, 4, 6, 8])");
        assertArrayEquals(new double[] {0.5, 0.5, 0.5}, sut.halveAll(new int[] {1, 1, 1}), 0.01, "halveAll([1, 1, 1])");
        assertArrayEquals(new double[] {1.5, 150}, sut.halveAll(new int[]{3, 300}), 0.01, "halveAll([3, 300])");
    }

}
