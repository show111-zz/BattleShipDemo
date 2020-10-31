package com.xerris.hannah.model;

import static com.xerris.hannah.constants.Constant.*;

public class Board {

    // the number of rows
    private final int numRows;
    // the number of column
    private final int numCols;
    // points on the board
    public String[][] board;

    // constructor: initial board
    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        board = new String[numRows][numCols];
    }

    // create the initial board
    public void createBoard() {
        System.out.print("        ");
        for (int i = 0; i < this.numCols; i++) {
            System.out.print((char) (CONSTANT_LETTER_UPPERCASE_A + i) + "\t\t");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY_POINT;
                if (j == 0) {
                    System.out.print((i + 1) + "\t\t");
                }
                System.out.print(board[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    // print current status of board
    public void printBoard() {
        System.out.println();
        System.out.print("        ");
        for (int i = 0; i < this.numCols; i++) {
            System.out.print((char) (CONSTANT_LETTER_UPPERCASE_A + i) + "\t\t");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) System.out.print((i + 1) + "\t\t");
                if (board[i][j] == null) {
                    System.out.print(EMPTY_POINT + "\t\t");
                } else {
                    System.out.print(board[i][j] + "\t\t");
                }
            }
            System.out.println();
        }
    }

    // the input coordinate and calculate the adjacent point when the direction is vertical
    public void handleX(int x, int y, String tag) {
        this.board[x][y] = tag;
        if (x == 0) {
            this.board[x + 1][y] = tag;
            this.board[x + 2][y] = tag;
        } else if (x == this.board.length - 1) {
            this.board[x - 1][y] = tag;
            this.board[x - 2][y] = tag;
        } else {
            this.board[x - 1][y] = tag;
            this.board[x + 1][y] = tag;
        }
    }

    // according to the input coordinate and calculate the adjacent point when the direction is horizontal
    public void handleY(int x, int y, String tag) {
        this.board[x][y] = tag;
        if (y == 0) {
            this.board[x][y + 1] = tag;
            this.board[x][y + 2] = tag;
        } else if (y == this.board[0].length - 1) {
            this.board[x][y - 1] = tag;
            this.board[x][y - 2] = tag;
        } else {
            this.board[x][y - 1] = tag;
            this.board[x][y + 1] = tag;
        }
    }

    // check current point is default tag "-"
    public boolean isEmpty(int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = EMPTY_POINT;
                }
            }
        }
        return board[x][y].equals(EMPTY_POINT);
    }

    // computer ship is hit or not
    public boolean isHitComputerShip(int x, int y) {
        return board[x][y].equals(COMPUTER_TAG);
    }

    // player ship is hit or not
    public boolean isHitPlayerShip(int x, int y) {
        return board[x][y].equals(PLAYER_TAG);
    }

    // set different tags to ships
    public void setBattleTag(int x, int y, String tag) {
        board[x][y] = tag;
    }
}
