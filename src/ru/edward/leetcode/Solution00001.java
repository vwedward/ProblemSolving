/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение задачи №1
 * https://leetcode.com/problems/two-sum/
 */
public class Solution00001 {
    //Решение вложенными циклами
    public static int[] twoSum_2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //Пытаемся сложить с каждым следующим числом
            if (i <= nums.length - 1) {
                for (int k = i + 1; k < nums.length; k++) {
                    if (nums[i] + nums[k] == target) {
                        return new int[]{i, k};
                    }
                }
            }
        }
        return null;
    }

    //Решение с помощью HashMap (самое шустрое)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
