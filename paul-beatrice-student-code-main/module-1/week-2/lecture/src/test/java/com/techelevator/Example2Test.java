package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example2Test {

    Example2 sut = new Example2();

    @Test
    public void testRoundOnBothEnds() {
        assertTrue(sut.roundOnBothEnds("Ohio"), "roundOnBothEnds(\"Ohio\")");
        assertTrue(sut.roundOnBothEnds("    OREO "), "roundOnBothEnds(\"    OREO \")");
        assertFalse(sut.roundOnBothEnds("ooooo!"), "roundOnBothEnds(\"ooooo!\")");
    }

    @Test
    public void testConCat() {
        assertEquals("abcat", sut.conCat("abc", "cat"), "conCat(\"abc\", \"cat\")");
        assertEquals("dogcat", sut.conCat("dog", "cat"), "conCat(\"dog\", \"cat\")");
        assertEquals("abc", sut.conCat("abc", ""), "conCat(\"abc\", \"\")");
    }

    @Test
    public void testEqualIsNot() {
        assertFalse(sut.equalIsNot("This is not"), "equalIsNot(\"This is not\")");
        assertTrue(sut.equalIsNot("This is notnot"), "equalIsNot(\"This is notnot\")");
        assertTrue(sut.equalIsNot("noisxxnotyynotxisi"), "equalIsNot(\"noisxxnotyynotxisi\")");
    }
}
