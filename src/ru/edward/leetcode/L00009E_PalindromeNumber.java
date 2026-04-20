/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

/**
 * Problem 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
public class L00009E_PalindromeNumber {
    /**
     * ИИ Оптимальное решение без pre-вычисления длины
     * Формируется вторая половина в инвертированном виде и сравнивается с первой
     * есл нечетное количество, то проверяется reversedHalf без последнего разряда, т.к.
     * при выходе из цикла reversedHalf >= х
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    /**
     * Изёвое решение
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder strBuilder = new StringBuilder().append(x);
        String str = strBuilder.toString();
        strBuilder.reverse();
        String revStr = strBuilder.toString();

        return str.equals(revStr);
    }

    /**
     * Не рабочий вариант (проблема с нулями в 1001)
     */
    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        // Делим на две части
        int left = x;
        int right = 0;
        int mult = 1;
        while (left > right) {
            right = (left % 10) * mult + right;
            left /= 10;
            mult *= 10;
        }
        // Переворачиваем правую
        int rightRev = 0;
        while (right > 0) {
            rightRev = rightRev * 10 + right % 10;
            right /= 10;
        }
        // Переворачиваем левую и считаем разряды
        int digs = 1;
        int leftRev = 0;
        while (left > 0) {
            leftRev = leftRev * 10 + left % 10;
            left /= 10;
            digs *= 10;
        }
        // Если результат инверсии не влезает в int - false
        if ((Integer.MAX_VALUE - leftRev) < rightRev * digs) {
            return false;
        }
        return rightRev * digs + leftRev == x;
    }
}
