/*
 * ©Edward, 2026
 */

/*
 * ©Edward, 2026
 */

package ru.edward.leetcode.notsolved;

import org.junit.jupiter.api.Test;
import ru.edward.leetcode.notsolved.L00010H_RegularExpressionMatching;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/
 */
class L00010H_RegularExpressionMatchingTest {
    private final L00010H_RegularExpressionMatching testObject = new L00010H_RegularExpressionMatching();

    @Test
    void RegularExpressionMatching1() {
        boolean result = testObject.isMatch("qweraabbbcde", "с*qwera*b*.*");
        assertTrue(result);
    }

    @Test
    void RegularExpressionMatching2() {
        boolean result = testObject.isMatch("aaa", "a*a");
        assertTrue(result);
    }
}