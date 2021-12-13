/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест решения задачи №3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Solution00003Test {

    @Test
    void lengthOfLongestSubstring() {
        try {
            assertEquals(0, Solution00003.lengthOfLongestSubstring(""));
            assertEquals(3, Solution00003.lengthOfLongestSubstring("abcabcbb"));
            assertEquals(1, Solution00003.lengthOfLongestSubstring("bbbbb"));
            assertEquals(3, Solution00003.lengthOfLongestSubstring("pwwkew"));

            assertEquals(0, Solution00003.lengthOfLongestSubstring_2(""));
            assertEquals(3, Solution00003.lengthOfLongestSubstring_2("abcabcbb"));
            assertEquals(1, Solution00003.lengthOfLongestSubstring_2("bbbbb"));
            assertEquals(3, Solution00003.lengthOfLongestSubstring_2("pwwkew"));
        }
        catch (Exception e) {
            System.out.println("e.getMessage" + e.getMessage());
        }
    }
}