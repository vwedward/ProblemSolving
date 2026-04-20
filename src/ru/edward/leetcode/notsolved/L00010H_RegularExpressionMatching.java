/*
 * ©Edward, 2026
 */

/*
 * ©Edward, 2026
 */

package ru.edward.leetcode.notsolved;

/**
 * Problem 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class L00010H_RegularExpressionMatching {
    /**
     * Вы выбрали путь «жадного однопроходного парсера» (жадного сопоставления с откатом назад).
     * Этот путь для данной задачи, к сожалению, принципиально неверен. Из-за того, что звёздочка
     * может означать «ноль или более повторений», вам нужно уметь пробовать разные варианты количества повторений,
     * а ваш текущий алгоритм выбирает максимальное возможное количество (жадно) и не возвращается назад,
     * если позже сопоставление не сходится.
     */
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int i = 0;
        int j = 0;
        // Отрабатываем шаблон
        while (i < pp.length && j < ss.length) {
            // Cлучай *
            if ((pp[i] != '*') && (i + 1 < pp.length) && (pp[i + 1] == '*')) {
                // dot*
                if (pp[i] == '.') {
                    j = ss.length;
                // сhar*
                } else {
                    // Пропускаем все подобные (их может вовсе не быть)
                    while (j < ss.length && ss[j] == pp[i]) { j++; }
                }
                i++; // т.к. отрабатываем два символа шаблона
            // Случай без *
            } else {
                // dot
                if (pp[i] == '.') {
                    j++;
                // сhar
                } else {
                    if (ss[j] != pp[i]) { return false; }
                    j++;
                }
            }
            i++;
        }
        return i == pp.length && j == ss.length;
    }
}
