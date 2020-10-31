package com.xerris.hannah.constants;

public class Constant {

    // the rows and columns for board
    public static final int NUM_ROWS = 8;
    public static final int NUM_COLUMNS = 8;

    // the "-" tag means empty on board
    public static final String EMPTY_POINT = "-";
    // the "0" tag shows the player's ship position on board
    public static final String PLAYER_TAG = "0";
    // the "*" tag shows the computer's ship position on board
    public static final String COMPUTER_TAG = "*";

    // characters
    public static final char CONSTANT_LETTER_UPPERCASE_A = 'A';
    public static final char CONSTANT_LETTER_LOWERCASE_A = 'a';
    public static final char CONSTANT_DIGIT_0 = '0';
    public static final char CONSTANT_DIGIT_9 = '9';

    // the direction for setting ships
    public static final String DIRECTION_VH = "VHvh";
    public static final String CONSTANT_LETTER_VV = "V";
    public static final String CONSTANT_LETTER_HH = "H";
    public static final String CONSTANT_LETTER_V = "v";
    public static final String CONSTANT_LETTER_H = "h";

    // player's ship start attack is missed or hit
    public static final String HIT_PLAYER_SHIP_TAG = "H";
    public static final String MISS_PLAYER_SHIP_TAG = "M";
    // computer ship start attack is missed or hit
    public static final String HIT_COMPUTER_SHIP_TAG = "h";
    public static final String MISS_COMPUTER_SHIP_TAG = "m";

    // the console tips for the player
    public static final String WELCOME = "**** Welcome To Battle Ships Game ****";
    public static final String PLACE_COMPUTER_SHIP = "\nStart placing computer's ship (done).";
    public static final String INPUT_SHIP_POSITION = "Enter [1-8][A-H] for your ship: ";
    public static final String INPUT_SHIP_DIRECTION = "Enter the direction for your ship(H/V): ";
    public static final String INPUT_SHIP_OUT_OF_BOUND = "You can't place ships outside the bound";
    public static final String PLAYER_SHIP_START_BATTLE = "Player start battle and input the attack point: ";
    public static final String COMPUTER_SHIP_START_BATTLE = "Computer start battle and generate a random point: ";
    public static final String PLAYER_SHIP_BATTLE_MISSED = "Sorry, you missed.";
    public static final String PLAYER_SHIP_BATTLE_HIT = "Boom! You hit the ship once!";
    public static final String COMPUTER_SHIP_BATTLE_MISSED = "Oops, computer missed";
    public static final String COMPUTER_SHIP_BATTLE_HIT = "Boom! Computer hit your ship once!";
    public static final String PLAYER_SHIP_BATTLE_FAIL = "Sorry, you lost the battleship";
    public static final String PLAYER_SHIP_BATTLE_WON = "Yes, you sunk the battleship";
    public static final String SHIP_BATTLE_RESULT = "Your ship hit times left: %d | Computer ship hit times left: %d";
}
