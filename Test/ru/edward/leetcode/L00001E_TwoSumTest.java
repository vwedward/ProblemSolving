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

    private final L00001E_TwoSum testObject = new L00001E_TwoSum();

    @Test
    void twoSum1() {
        int[] res = testObject.twoSum1(nums, target);
        assertArrayEquals(expRes, res);
    }
    @Test
    void twoSum2() {
        int[] res = testObject.twoSum2(nums, target);
        assertArrayEquals(expRes, res);
    }
}