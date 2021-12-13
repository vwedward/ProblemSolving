/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import java.util.HashSet;
import java.util.Set;


/**
 * Решение задачи №3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution00003 {

    //Решение через Set (быстро)
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    //Решение "в лоб"
    public static int lengthOfLongestSubstring_2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int fromIndex = 0;
        int maxLength = 1;

        do {
            int toIndex = s.length() - 1;
            int charIndex = fromIndex;
            do {
                //Ищем такой же символ что и в позиции fromIndex
                int findIndex = s.indexOf(s.charAt(charIndex), charIndex + 1);
                //Меняем позицию конца неповторяющейся строки только в случае
                //если нашли такой же символ в диапазоне от 0 до toIndex - 1
                if ((findIndex != -1) && (findIndex <= toIndex)) {
                    toIndex = findIndex - 1;
                }
                charIndex++;
            }
            while (charIndex < toIndex);
            if (toIndex - fromIndex + 1 > maxLength) {
                maxLength = toIndex - fromIndex + 1;
            }
            fromIndex++;
        }
        while (fromIndex < s.length() - 1);

        return maxLength;
    }
}
