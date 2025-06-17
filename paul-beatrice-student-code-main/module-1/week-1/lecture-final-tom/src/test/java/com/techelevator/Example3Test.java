package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example3Test {

    private final Example3 sut = new Example3();

    @Test
    public void testReturnAdultOrMinorOrTeen() {
        assertEquals("Adult", sut.ageGroup(18), "returnAdultOrMinorOrTeen(18)");
        assertEquals("Teen", sut.ageGroup(17), "returnAdultOrMinorOrTeen(17)");
        assertEquals("Teen", sut.ageGroup(13), "returnAdultOrMinorOrTeen(13)");
        assertEquals("Child", sut.ageGroup(12), "returnAdultOrMinorOrTeen(12)");

    }

    @Test
    public void testGreenTicket() {
        assertEquals(0, sut.greenTicket(1, 2, 3), "greenTicket(1, 2, 3)");
        assertEquals(20, sut.greenTicket(2, 2, 2), "greenTicket(2, 2, 2)");
        assertEquals(10, sut.greenTicket(1, 1, 2), "greenTicket(1, 1, 2)");
        assertEquals(10, sut.greenTicket(2, 1, 1), "greenTicket(2, 1, 1)");
        assertEquals(10, sut.greenTicket(1, 2, 1), "greenTicket(1, 2, 1)");
    }

    @Test
    public void testBlackjack() {
        assertEquals(21, sut.blackjack(19, 21), "blackjack(19, 21)");
        assertEquals(21, sut.blackjack(21, 19), "blackjack(21, 19)");
        assertEquals(19, sut.blackjack(19, 22), "blackjack(19, 22)");
        assertEquals(19, sut.blackjack(22, 19), "blackjack(22, 19)");
        assertEquals(0, sut.blackjack(23, 22), "blackjack(23, 22)");
        assertEquals(0, sut.blackjack(23, 22), "blackjack(10, 12)");
        assertEquals(21, sut.blackjack(21, 21), "blackjack(21, 21)");
        assertEquals(17, sut.blackjack(17, 17), "blackjack(17, 17)");
    }

}
