/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
class L00008M_StringToIntegerAtoiTest {
    L00008M_StringToIntegerAtoi testObject = new L00008M_StringToIntegerAtoi();

    @Test
    void StringToIntegerAtoi1() {
        int result = testObject.myAtoi("123");
        assertEquals(123, result);
    }

    @Test
    void StringToIntegerAtoi2() {
        int result = testObject.myAtoi("words and 987");
        assertEquals(0, result);
    }

    @Test
    void StringToIntegerAtoi3() {
        int result = testObject.myAtoi("-91283472332");
        assertEquals(-2147483648, result);
    }


}