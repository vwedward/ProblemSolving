/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class L00005M_LongestPalindromicSubstringTest {
    private final L00005M_LongestPalindromicSubstring testObject = new L00005M_LongestPalindromicSubstring();

    @Test
    void LongestPalindromicSubstring1() {
        String longestPalindrome = testObject.longestPalindrome("babad");
        assertTrue(longestPalindrome.equals("bab") || longestPalindrome.equals("aba"));
    }

    @Test
    void LongestPalindromicSubstring2() {
        String longestPalindrome = testObject.longestPalindrome("a");
        assertEquals(longestPalindrome, "a");
    }

}