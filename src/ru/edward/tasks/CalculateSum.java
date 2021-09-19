/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Optional;

/**
 * Решение задачи с собеседования Сулейманова
 * https://www.youtube.com/watch?v=CS69TAO8nVw&list=PLlsMRoVt5sTMMCwd_gLaaZMkQhzVh9hLA&index=16&t=2534s
 */
//123456789
public class CalculateSum {

    public static Integer calculateSum(String input) {
        Integer result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += Integer.parseInt(input.substring(i, i + 1));
        }
        return result;
    }

    public static Integer calculateSumStream(String input) {
        String[] arr = input.split("");
        Optional<Integer> result = Arrays.stream(arr).map(o -> Integer.parseInt(o)).reduce((x,y)->x+y);
        return result.get();
    }

}