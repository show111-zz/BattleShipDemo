package com.xerris.hannah.utils;

import com.xerris.hannah.model.Ship;

import java.util.Random;
import java.util.Scanner;

import static com.xerris.hannah.constants.Constant.*;

public class CalculateUtil {

    // set tag to the board according to the direction
    public static void setShipPointBaseDirectionToBoard(Ship ship) {
        int x = ship.getPosX();
        int y = ship.getPosY();
        if (ship.getDirection().equals(CONSTANT_LETTER_VV) || ship.getDirection().equals(CONSTANT_LETTER_V)) {
            ship.getBoard().handleX(x, y, ship.getTag());
        } else if (ship.getDirection().equals(CONSTANT_LETTER_HH) || ship.getDirection().equals(CONSTANT_LETTER_H)) {
            ship.getBoard().handleY(x, y, ship.getTag());
        }
    }

    // generate the computer's direction
    public static String generateDirectionForComputer() {
        Random random = new Random();
        int index = random.nextInt(DIRECTION_VH.length());
        return String.valueOf(DIRECTION_VH.charAt(index));
    }

    // get the direction from player's input
    public static String getDirectionFromPlayer() {
        System.out.print(INPUT_SHIP_DIRECTION);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    // check the letter is between 0 and 9
    public static boolean isBetween0To9(char c) {
        return (c > CONSTANT_DIGIT_0 && c < CONSTANT_DIGIT_9);
    }

    // check the letter is between A and H
    public static boolean isBetweenUpperCaseAToH(char c) {
        return c >= CONSTANT_LETTER_UPPERCASE_A && c <= (CONSTANT_LETTER_UPPERCASE_A + NUM_ROWS);
    }

    // check the letter is between a and h
    public static boolean isBetweenLowerCaseAToH(char c) {
        return c >= CONSTANT_LETTER_LOWERCASE_A && c <= (CONSTANT_LETTER_LOWERCASE_A + NUM_ROWS);
    }
}
