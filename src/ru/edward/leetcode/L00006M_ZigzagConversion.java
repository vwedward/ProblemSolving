/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class L00006M_ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // Инициализируем массив
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int curPos = 0;
        boolean isVertical = true;
        int z = numRows - 2; // номер строки в диагонали. Это значение перетрется ниже

        while (curPos < s.length()) {
            // Заполняем колонку
            for (int i = 0; i < numRows && curPos < s.length(); i++) {
                // Вертикаль
                if (isVertical) {
                    rows.get(i).append(s.charAt(curPos));
                    curPos++;
                    // Если отрисовали последний, переходим к вертикали
                    // в случае numRows = 2 диагонали нет
                    if (i == numRows - 1 && numRows > 2) {
                        z = numRows - 2;
                        isVertical = false;
                    }
                // Диагональ
                } else {
                    rows.get(i).append(i == z ? s.charAt(curPos) : ' ');
                    // Переходим к следующему символу только когда заполнили всю колонку
                    if (i == numRows - 1) {
                        curPos++;
                        z--;
                    }
                    // Если заполнили диагональ, переходим к вертикали
                    if (z == 0) {
                        isVertical = true;
                    }
                }
            }
        }

        System.out.println("Параметр: " + s);
        StringBuilder result = new StringBuilder();
        for (StringBuilder str: rows) {
            System.out.println(str);
            result.append(str);
        }
        String resultStr = result.toString().replaceAll("\\s+", "");
        System.out.println("Результат: " + resultStr);
        return resultStr;
    }

    /**
     * Убрал работу с пробелами, которые не имеют смысла для получения результата
     * Быстрее в 3 раза
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // Инициализируем массив
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int curPos = 0;
        boolean isVertical = true;
        int z = numRows - 2; // номер строки в диагонали. Это значение перетрется ниже

        while (curPos < s.length()) {
            // Заполняем колонку
            for (int i = 0; i < numRows && curPos < s.length(); i++) {
                // Вертикаль
                if (isVertical) {
                    rows.get(i).append(s.charAt(curPos));
                    curPos++;
                    // Если отрисовали последний, переходим к вертикали
                    // в случае numRows = 2 диагонали нет
                    if (i == numRows - 1 && numRows > 2) {
                        z = numRows - 2;
                        isVertical = false;
                    }
                    // Диагональ
                } else {
                    if (i == z) {
                        rows.get(i).append(s.charAt(curPos));
                    }
                    // Переходим к следующему символу только когда заполнили всю колонку
                    if (i == numRows - 1) {
                        curPos++;
                        z--;
                    }
                    // Если заполнили диагональ, переходим к вертикали
                    if (z == 0) {
                        isVertical = true;
                    }
                }
            }
        }

        System.out.println("Параметр: " + s);
        StringBuilder result = new StringBuilder();
        for (StringBuilder str: rows) {
            System.out.println(str);
            result.append(str);
        }
        String resultStr = result.toString();
        System.out.println("Результат: " + resultStr);
        return resultStr;
    }

    /**
     *  Оптимизированное решение от ИИ
     *  быстрее в 10 раз
     */
    public String convert3(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);

            // Меняем направление в крайних строках
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        // Объединяем без лишних операций
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

}
