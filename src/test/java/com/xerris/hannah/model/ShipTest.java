package com.xerris.hannah.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipTest {
    Ship shipTest;

    @BeforeEach
    void setUp() {
        shipTest = new Ship();
        shipTest.setPosX(2);
        shipTest.setPosY(3);
        shipTest.setDirection("v");
        shipTest.setTag("*");
        shipTest.setBoard(new Board(8, 7));
    }

    @Test
    void getPosXShouldReturnInstanceValue() {
        assertEquals(2, shipTest.getPosX());
    }

    @Test
    void getPosYShouldReturnInstanceValue() {
        assertEquals(3, shipTest.getPosY());
    }

    @Test
    void getDirectionShouldReturnInstanceValue() {
        assertEquals("v", shipTest.getDirection());
    }

    @Test
    void getTagShouldReturnInstanceValue() {
        assertEquals("*", shipTest.getTag());
    }

    @Test
    void getBoardShouldReturnInstanceValue() {
        assertEquals(8, shipTest.getBoard().board.length);
        assertEquals(7, shipTest.getBoard().board[0].length);
    }
}