package com.xerris.hannah.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculateUtilTest {

    @Test
    void isBetween0To9WhenGivenCorrectNumReturnTrue() {
        assertTrue(CalculateUtil.isBetween0To9('4'));
    }

    @Test
    void isBetween0To9WhenGivenZeroReturnFalse() {
        assertFalse(CalculateUtil.isBetween0To9('0'));
    }

    @Test
    void isBetween0To9WhenGivenNineReturnFalse() {
        assertFalse(CalculateUtil.isBetween0To9('9'));
    }

    @Test
    void isBetween0To9WhenGivenLetterReturnFalse() {
        assertFalse(CalculateUtil.isBetween0To9('c'));
    }

    @Test
    void isBetweenUpperCaseAToHWhenGivenCorrectReturnTrue() {
        assertTrue(CalculateUtil.isBetweenUpperCaseAToH('C'));
    }

    @Test
    void isBetweenUpperCaseAToHWhenGivenOutOfBoundaryReturnFalse() {
        assertFalse(CalculateUtil.isBetweenUpperCaseAToH('K'));
    }

    @Test
    void isBetweenUpperCaseAToHWhenGivenNumberReturnFalse() {
        assertFalse(CalculateUtil.isBetweenUpperCaseAToH('4'));
    }

    @Test
    void isBetweenLowerCaseAToHWhenGivenCorrectReturnTrue() {
        assertTrue(CalculateUtil.isBetweenLowerCaseAToH('f'));
    }

    @Test
    void isBetweenLowerCaseAToHWhenGivenOutOfBoundaryReturnFalse() {
        assertFalse(CalculateUtil.isBetweenLowerCaseAToH('p'));
    }

    @Test
    void isBetweenLowerCaseAToHWhenGivenNumberReturnFalse() {
        assertFalse(CalculateUtil.isBetweenLowerCaseAToH('9'));
    }
}