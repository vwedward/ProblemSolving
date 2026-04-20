/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L00011_ContainerWithMostWaterTest {
    private final L00011_ContainerWithMostWater testObject = new L00011_ContainerWithMostWater();

    @Test
    void containerWithMostWater1() {
        int[] testArr = {1,8,6,2,5,4,8,3,7};
        int result = testObject.maxArea(testArr);
        assertEquals(49, result);
    }

    @Test
    void containerWithMostWater2() {
        int[] testArr = {1,1};
        int result = testObject.maxArea(testArr);
        assertEquals(1, result);
    }
}