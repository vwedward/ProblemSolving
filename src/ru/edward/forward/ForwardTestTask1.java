/*
 * ©Edward, 2022
 */

package ru.edward.forward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Решение тестовой задачи 1 компании Forward telecom
 * <p>
 * Имеется список(List) целых чисел. Напишите код функции, которая для каждого положительного числа из списка
 * вычисляет квадрат, и возвращает строку из полученных значений, разделенных запятой. Следует использовать java 8 streams.
 * <p>
 * Пример входных данных: {3, 0, -5, 2, -2, 3}
 * Пример возвращаемого значения: "9,4,9"
 */

public class ForwardTestTask1 {
    public static String positiveSquare(List<Integer> nums) {
        return nums.stream().filter(o -> o > 0).map(o -> (o * o)).map(Object::toString).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(3, 0, -5, 2, -2, 3);
        System.out.println(positiveSquare(l));
    }
}
