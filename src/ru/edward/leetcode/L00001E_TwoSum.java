/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class L00001E_TwoSum {
    // Решение вложенными циклами
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //Пытаемся сложить с каждым следующим числом
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] + nums[k] == target) {
                    return new int[]{i, k};
                }
            }
        }
        return null;
    }

    // Решение с помощью HashMap (самое шустрое)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
