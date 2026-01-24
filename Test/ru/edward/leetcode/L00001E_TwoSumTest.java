/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
class L00001E_TwoSumTest {
    private static final int[] nums = {2, 7, 11, 15};
    private static final int target = 9;
    private static final int[] expRes = {0, 1};

    @Test
    void twoSum1() {
        int[] res = L00001E_TwoSum.twoSum1(nums, target);
        assertArrayEquals(expRes, res);
    }
    @Test
    void twoSum2() {
        int[] res = L00001E_TwoSum.twoSum2(nums, target);
        assertArrayEquals(expRes, res);
    }
}