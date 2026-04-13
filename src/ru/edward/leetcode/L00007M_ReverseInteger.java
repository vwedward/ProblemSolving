/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

/**
 * Problem 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 * 123%10 = 3   3
 * 12%10 = 2    2*10+3
 * 1%10 = 1     (2*10+3) * 10 + 2
 */
public class L00007M_ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int rest;
        int num = Math.abs(x);
        int sign = x / num;
        int result = 0;
        int mult = 1;
        do {
            rest = num%10;
            num /= 10;
            if (result > (Integer.MAX_VALUE - rest) / 10) {
                return 0;  // будет переполнение
            }
            result = (result * mult) + rest;
            if (mult == 1) {
                mult = 10;
            };
        } while (num != 0);
       return result * sign;
    }
}
