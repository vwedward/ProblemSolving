/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
class L00009E_PalindromeNumberTest {
    private final L00009E_PalindromeNumber testObject = new L00009E_PalindromeNumber();

    @Test
    void PalindromeNumber1() {
        boolean result = testObject.isPalindrome(123321);
        assertTrue(result);
    }

    @Test
    void PalindromeNumber2() {
        boolean result = testObject.isPalindrome(10);
        assertFalse(result);
    }

    @Test
    void PalindromeNumber3() {
        boolean result = testObject.isPalindrome(1001);
        assertTrue(result);
    }

    @Test
    void PalindromeNumber4() {
        boolean result = testObject.isPalindrome(12321);
        assertTrue(result);
    }
}