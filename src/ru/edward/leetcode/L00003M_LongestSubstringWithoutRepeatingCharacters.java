/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class L00003M_LongestSubstringWithoutRepeatingCharacters {

    // Решение через Set (быстро)
    // Поддерживаем окно [l, r], в котором все символы уникальны.
    // Когда встречаем повторяющийся символ — сдвигаем левую границу
    // окна l вправо, пока повторение не исчезнет.
    public int lengthOfLongestSubstring(String s) {
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

    // Решение "в лоб"
    // Для каждой начальной позиции fromIndex ищем максимальную правую границу toIndex,
    // где все символы уникальны. Как только встречаем повтор — сдвигаем toIndex влево.
    public int lengthOfLongestSubstring_2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int fromIndex = 0;
        int maxLength = 1;

        // В этом цикле при неудаче мы двигаем только правую границу!!!
        // charIndex двигаем только в целях проверки, а не в целях сдвига левой границы
        do {
            int toIndex = s.length() - 1;
            // Инициализируем текущий символ
            int charIndex = fromIndex;
            do {
                // Ищем после него такой же символ
                int findIndex = s.indexOf(s.charAt(charIndex), charIndex + 1);
                // Если нашли, двигаем правую границу до этого повторного символа
                if ((findIndex != -1) && (findIndex <= toIndex)) {
                    toIndex = findIndex - 1;
                }
                // Меняем текущий символ
                charIndex++;
            }
            while (charIndex < toIndex);

            // В этой точке результат - набор неповторяющихся символов в диапазоне fromIndex и toIndex
            maxLength = Math.max(maxLength, toIndex - fromIndex + 1);

            fromIndex++;
        }
        while (fromIndex < s.length() - 1);

        return maxLength;
    }
}
