/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
class L00007M_ReverseIntegerTest {
    private final L00007M_ReverseInteger testObject = new L00007M_ReverseInteger();

    @Test
    void ReverseInteger1() {
        int result = testObject.reverse(123);
        assertEquals(result, 321);
    }

    @Test
    void ReverseInteger2() {
        int result = testObject.reverse(-123);
        assertEquals(result, -321);
    }

    @Test
    void ReverseInteger3() {
        int result = testObject.reverse(1234567899);
        assertEquals(result, 0);
    }
}