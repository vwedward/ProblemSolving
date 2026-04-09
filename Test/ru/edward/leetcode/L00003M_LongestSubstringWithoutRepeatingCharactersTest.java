/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class L00003M_LongestSubstringWithoutRepeatingCharactersTest {
    private final L00003M_LongestSubstringWithoutRepeatingCharacters testObject =
            new L00003M_LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring() {
        try {
            assertEquals(0, testObject.lengthOfLongestSubstring(""));
            assertEquals(3, testObject.lengthOfLongestSubstring("abcabcbb"));
            assertEquals(1, testObject.lengthOfLongestSubstring("bbbbb"));
            assertEquals(3, testObject.lengthOfLongestSubstring("pwwkew"));

            assertEquals(0, testObject.lengthOfLongestSubstring_2(""));
            assertEquals(3, testObject.lengthOfLongestSubstring_2("abcabcbb"));
            assertEquals(1, testObject.lengthOfLongestSubstring_2("bbbbb"));
            assertEquals(3, testObject.lengthOfLongestSubstring_2("pwwkew"));
        }
        catch (Exception e) {
            System.out.println("e.getMessage" + e.getMessage());
        }
    }
}