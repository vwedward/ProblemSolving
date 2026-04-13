/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
class L00006M_ZigzagConversionTest {
    private final L00006M_ZigzagConversion testObject = new L00006M_ZigzagConversion();

    @Test
    void zigzagConversion1() {
        String converted = testObject.convert("PAYPALISHIRING", 3);
        assertEquals(converted,"PAHNAPLSIIGYIR");
    }

    @Test
    void zigzagConversion2() {
        String converted = testObject.convert("PAYPALISHIRING", 4);
        assertEquals(converted,"PINALSIGYAHRPI");
    }

    @Test
    void zigzagConversion3() {
        String converted = testObject.convert("AB", 1);
        assertEquals(converted,"AB");
    }

    @Test
    void zigzagConversion4() {
        String converted = testObject.convert("ABC", 2);
        assertEquals(converted,"ACB");
    }
}