package com.xerris.hannah.battle;

import com.xerris.hannah.model.Board;
import com.xerris.hannah.model.Ship;
import com.xerris.hannah.utils.CalculateUtil;

import java.util.Scanner;

import static com.xerris.hannah.constants.Constant.*;

public class BattleShips {

    // Total number of attacks on player
    private int hitPlayerNum = 3;
    // Total number of attacks on Computer
    private int hitComputerNum = 3;

    // set up player ship
    public Ship setupPlayerShip() {
        Ship playerShip = new Ship();
        String position = placeShipOnBoard();
        int x = Character.getNumericValue(position.charAt(0));
        playerShip.setPosX(x - 1);
        int y = position.charAt(1) - CONSTANT_LETTER_UPPERCASE_A;
        playerShip.setPosY(y);
        playerShip.setTag(PLAYER_TAG);
        playerShip.setDirection(CalculateUtil.getDirectionFromPlayer());
        Board boardUser = new Board(NUM_ROWS, NUM_COLUMNS);
        playerShip.setBoard(boardUser);
        return playerShip;
    }

    // set up computer ship
    public Ship setupComputerShip() {
        System.out.println(PLACE_COMPUTER_SHIP);
        int x = (int) (Math.random() * NUM_ROWS);
        int y = (int) (Math.random() * NUM_COLUMNS);
        Ship computerShip = new Ship();
        computerShip.setPosX(x);
        computerShip.setPosY(y);
        computerShip.setTag(COMPUTER_TAG);
        computerShip.setDirection(CalculateUtil.generateDirectionForComputer());
        Board boardComputer = new Board(NUM_ROWS, NUM_COLUMNS);
        computerShip.setBoard(boardComputer);
        return computerShip;
    }

    // player's ship and computer start battle
    public void startBattle(Ship playerShip, Ship computerShip) {
        do {
            if (hitComputerNum > 0 && hitPlayerNum != 0) {
                playerTurnToBattle(computerShip);
            }
            if (hitPlayerNum > 0 && hitComputerNum != 0) {
                computerTurnToBattle(playerShip);
            }
        } while (hitPlayerNum > 0 && hitComputerNum > 0);
    }

    // place ship to board
    public String placeShipOnBoard() {
        String position;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(INPUT_SHIP_POSITION);
            position = input.nextLine();
        } while (position.length() != 2 ||
                (!Character.isDigit(Character.getNumericValue(position.charAt(0)))
                        && !Character.isLetter(position.charAt(1))) ||
                !CalculateUtil.isBetween0To9(position.charAt(0)) ||
                !(CalculateUtil.isBetweenUpperCaseAToH(position.charAt(1)) ||
                        CalculateUtil.isBetweenLowerCaseAToH(position.charAt(1)))
        );

        if (CalculateUtil.isBetween0To9(position.charAt(0)) &&
                (CalculateUtil.isBetweenUpperCaseAToH(position.charAt(1))
                        || CalculateUtil.isBetweenLowerCaseAToH(position.charAt(1)))) {
            return String.valueOf(position.charAt(0)) + Character.toUpperCase(position.charAt(1));
        } else {
            System.out.println(INPUT_SHIP_OUT_OF_BOUND);
            return EMPTY_POINT;
        }
    }

    // player ship starts to battle
    private void playerTurnToBattle(Ship shipComputer) {
        System.out.println(PLAYER_SHIP_START_BATTLE);
        int x, y;
        do {
            String position = placeShipOnBoard();
            x = Character.getNumericValue(position.charAt(0)) - 1;
            y = position.charAt(1) - CONSTANT_LETTER_UPPERCASE_A;
            while (!Character.isLetter(position.charAt(1)) && Character.isLowerCase(position.charAt(1))) {
                position = placeShipOnBoard();
            }

            if ((x >= 0 && x < NUM_ROWS) && (y >= 0 && y < NUM_COLUMNS)) {
                if (shipComputer.getBoard().isEmpty(x, y)) {
                    System.out.println(PLAYER_SHIP_BATTLE_MISSED);
                    shipComputer.getBoard().setBattleTag(x, y, MISS_PLAYER_SHIP_TAG);
                } else if (shipComputer.getBoard().isHitComputerShip(x, y)) {
                    System.out.println(PLAYER_SHIP_BATTLE_HIT);
                    hitComputerNum--;
                    shipComputer.getBoard().setBattleTag(x, y, HIT_PLAYER_SHIP_TAG);
                }
            }
            System.out.printf((SHIP_BATTLE_RESULT) + "%n", hitPlayerNum, hitComputerNum);
        } while ((x < 0 || x >= NUM_ROWS) || (y < 0 || y >= NUM_COLUMNS));
    }

    // computer ship starts to battle
    private void computerTurnToBattle(Ship shipUser) {
        System.out.println(COMPUTER_SHIP_START_BATTLE);
        int x, y;
        do {
            x = (int) (Math.random() * NUM_ROWS);
            y = (int) (Math.random() * NUM_COLUMNS);
            while (!shipUser.getBoard().isEmpty(x, y)) {
                x = (int) (Math.random() * NUM_ROWS);
                y = (int) (Math.random() * NUM_COLUMNS);
            }
            if ((x >= 0 && x < NUM_ROWS) && (y >= 0 && y < NUM_COLUMNS)) {
                if (shipUser.getBoard().isEmpty(x, y)) {
                    System.out.println(COMPUTER_SHIP_BATTLE_MISSED);
                    shipUser.getBoard().setBattleTag(x, y, MISS_COMPUTER_SHIP_TAG);
                } else if (shipUser.getBoard().isHitPlayerShip(x, y)) {
                    hitPlayerNum--;
                    shipUser.getBoard().setBattleTag(x, y, HIT_COMPUTER_SHIP_TAG);
                    System.out.println(COMPUTER_SHIP_BATTLE_HIT);
                }
            }
            shipUser.getBoard().printBoard();
            System.out.printf((SHIP_BATTLE_RESULT) + "%n", hitPlayerNum, hitComputerNum);
        } while ((x < 0 || x >= NUM_ROWS) || (y < 0 || y >= NUM_COLUMNS));
    }

    // game over
    public void gameOver() {
        System.out.println();
        if (hitPlayerNum <= 0 && hitComputerNum > 0) {
            System.out.println(PLAYER_SHIP_BATTLE_FAIL);
        } else {
            System.out.println(PLAYER_SHIP_BATTLE_WON);
        }
        System.out.println();
    }
}
