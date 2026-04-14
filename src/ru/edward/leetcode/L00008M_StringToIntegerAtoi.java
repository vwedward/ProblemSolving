/*
 * ©Edward, 2026
 */

package ru.edward.leetcode;

/**
 * Problem 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class L00008M_StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        };
        char[] arr = s.toCharArray();
        int i = 0;
        int sign; // 1 или -1
        // The algorithm for myAtoi(string s) is as follows:
        // 1. Whitespace: Ignore any leading whitespace (" ").
        while (i < arr.length && arr[i] == ' ') {
            i++;
        }
        if (i == arr.length) {
            return 0;
        }
        // 2. Signedness: Determine the sign by checking if the next character is '-' or '+',
        // assuming positivity if neither present.
        if (arr[i] == '-' || arr[i] == '+') {
            sign = arr[i] == '-' ? -1 : 1;
            i++;
        } else if (Character.isDigit(arr[i])) {
            sign = 1;
        } else {
            return 0;
        }
        // 3. Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered
        // or the end of the string is reached. If no digits were read, then the result is 0.
        // 4. Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
        // then round the integer to remain in the range. Specifically, integers less than -231 should be
        // rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
        while (i < arr.length && arr[i] == '0') {
            i++;
        }
        int result = 0;
        while (i < arr.length && Character.isDigit(arr[i]))
        {
            // Переполнение
            if (result > (Integer.MAX_VALUE - (arr[i] - '0'))/10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // Добавляем в результат
            result = result * 10 + (arr[i] - '0');
            i++;
        }
        if (i == arr.length - 1 && arr[i] == '0') {
            return 0;
        }
        result = result * sign;
        return result;
    }

    /**
     * Этот вариант не точно отражает постановку задачи. Надо было делать тупо описанный алгоритм
     */
    public int myAtoi2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        };
        char[] arr = s.toCharArray();
        int i = 0;
        int sign; // 1 или -1

        // Ищем знак, пока не упремся в конец или цифру
        do {
            // Не нашли ни знак ни конец
            if (i == arr.length) {
                return 0;
            }
            // Цифра (значит знак +)
            if (Character.isDigit(arr[i])) {
                sign = 1;
                break;
            }
            //Нашли знак
            if (arr[i] == '-' || arr[i] == '+') {
                sign = arr[i] == '-' ? -1 : 1;
                i++; // Позиционируемся после знака
                break;
            }
            i++;
        } while (true);

        // Пропускаем пробелы и нули
        while (i < arr.length && (arr[i] == ' ' || arr[i] == '0')) {
            i++;
        }

        // Формируем результат, пока цифры
        int result = 0;
        while (i < arr.length && Character.isDigit(arr[i]))
        {
            // Переполнение
            if (result > (Integer.MAX_VALUE - (arr[i] - '0'))/10) {
                return 0;
            }
            // Добавляем в результат
            result = result * 10 + (arr[i] - '0');
            i++;
        }

        if (i == arr.length - 1 && arr[i] == '0') {
            return 0;
        }

        result = result * sign;

        return result;
    }
}
