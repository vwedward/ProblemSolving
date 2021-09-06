/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест решения задачи №1
 * https://leetcode.com/problems/two-sum/
 */
class Solution00001Test {
    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = Solution00001.twoSum(nums, target);

        int[] expRes = {0, 1};

        assertArrayEquals(expRes, res);
    }
}