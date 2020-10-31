package com.xerris.hannah.entry;

import com.xerris.hannah.battle.BattleShips;
import com.xerris.hannah.model.Board;
import com.xerris.hannah.model.Ship;
import com.xerris.hannah.utils.CalculateUtil;

import static com.xerris.hannah.constants.Constant.*;

public class BattleEntry {

    public static void main(String[] args) {
        System.out.println(WELCOME);

        //Step 1 – create and show the initial board
        BattleShips battleShips = new BattleShips();
        Board boardInit = new Board(NUM_ROWS, NUM_COLUMNS);
        boardInit.createBoard();

        //Step 2 – create and place player’s ship
        Ship userShip = battleShips.setupPlayerShip();
        CalculateUtil.setShipPointBaseDirectionToBoard(userShip);
        userShip.getBoard().printBoard();

        //Step 3 - randomly create and place computer's ship
        Ship computerShip = battleShips.setupComputerShip();

        //Step 4 - player's ship and computer's ship start battle
        battleShips.startBattle(userShip, computerShip);

        //Step 5 - Game over
        battleShips.gameOver();
    }
}
