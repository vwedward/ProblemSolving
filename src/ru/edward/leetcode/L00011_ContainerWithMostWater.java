/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

/**
 * Problem 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class L00011_ContainerWithMostWater {
    /**
     * Идём слева и справа, отбрасывая минимальный, т.к. сочетание с ним оставшихся значений не даст больше максимума
     * Т.к. этот самый минимальный ограничивает высоту столба сверху, а уменьшение ширины ведет к уменьшению объема
     */
    public int maxArea(int[] height) {
        int maxV = 0;
        int v;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            v = Math.min(height[l], height[r]) * (r-l);
            maxV = Math.max(maxV, v);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxV;
    }
}
