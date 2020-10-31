package com.xerris.hannah.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board boards;

    @BeforeEach
    void setUp() {
        boards = new Board(8, 8);
        boards.createBoard();
    }

    @Test
    void handleWhenXIsZeroReturnTwoPoints() {
        boards.handleX(0, 2, "*");
        assertEquals("*", boards.board[1][2]);
        assertEquals("*", boards.board[2][2]);
    }

    @Test
    void handleWhenXIsMaxReturnTwoPoints() {
        boards.handleX(7, 3, "*");
        assertEquals("*", boards.board[7][3]);
        assertEquals("*", boards.board[6][3]);
    }

    @Test
    void handleWhenXIsMiddleReturnTwoPoints() {
        boards.handleX(4, 3, "*");
        assertEquals("*", boards.board[3][3]);
        assertEquals("*", boards.board[5][3]);
    }

    @Test
    void handleWhenYIsZeroReturnTwoPoints() {
        boards.handleY(2, 0, "#");
        assertEquals("#", boards.board[2][1]);
        assertEquals("#", boards.board[2][2]);
    }

    @Test
    void handleWhenYIsMaxReturnTwoPoints() {
        boards.handleY(2, 7, "#");
        assertEquals("#", boards.board[2][7]);
        assertEquals("#", boards.board[2][6]);
    }

    @Test
    void handleWhenYIsMiddleReturnTwoPoints() {
        boards.handleY(2, 4, "#");
        assertEquals("#", boards.board[2][3]);
        assertEquals("#", boards.board[2][5]);
    }

    @Test
    void isEmptyWhenDashReturnTrue() {
        boards.board[2][3] = "-";
        assertTrue(boards.isEmpty(2, 3));
    }

    @Test
    void isEmptyWhenPoundReturnFalse() {
        boards.board[5][6] = "#";
        assertFalse(boards.isEmpty(5, 6));
    }

    @Test
    void isHitComputerShipWhenStarReturnTrue() {
        boards.board[5][6] = "*";
        assertTrue(boards.isHitComputerShip(5, 6));
    }

    @Test
    void isHitComputerShipWhenPoundReturnFalse() {
        boards.board[5][6] = "#";
        assertFalse(boards.isHitComputerShip(5, 6));
    }

    @Test
    void isHitUserShipWhenZeroReturnTrue() {
        boards.board[2][4] = "0";
        assertTrue(boards.isHitPlayerShip(2, 4));
    }

    @Test
    void isHitUserShipWhenStarReturnFalse() {
        boards.board[2][4] = "*";
        assertFalse(boards.isHitPlayerShip(2, 4));
    }

    @Test
    void setBattleTag() {
        boards.board[2][5] = "*";
        assertEquals("*", boards.board[2][5]);
        assertNotEquals("#", boards.board[2][5]);
    }
}