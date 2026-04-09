/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

/**
 * Problem 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class L00005M_LongestPalindromicSubstring {
    /**
     * Constraints:
     *  1 <= s.length <= 1000
     *  s consist of only digits and English letters.
     */
    public String longestPalindrome(String s) {
        // Т.к. входной параметр не пуст, считаем что начальный палиндром равен первому символу
        String result = s.substring(0, 1);
        // Перебираем символы, предполагая что каждый из них центр палиндрома
        for (int i = 0; i < s.length(); i++) {
            // Смотрим слева и справа от текущего (палиндром с нечетным кол-вом символов)
            for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    // Найденный палиндром длиннее
                    if (j * 2 + 1 > result.length()){
                        result = s.substring(i - j, i + j + 1); // +1, т.к. правая граница не включительно
                    }
                }
                else break;
            }
            // Смотрим текущий и справа от него (палиндром с четным кол-вом символов)
            for (int j = 0; i - j >= 0 && i + j + 1 < s.length() ;j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    if (j * 2 + 2 > result.length()) {
                        result = s.substring(i - j, i + j + 1 + 1); // +1, т.к. правая граница не включительно
                    }
                }
                else break;
            }
        }
        return result;
    }
}
