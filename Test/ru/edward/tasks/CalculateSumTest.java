/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест решения задачи с собеседования Сулейманова
 * https://www.youtube.com/watch?v=CS69TAO8nVw&list=PLlsMRoVt5sTMMCwd_gLaaZMkQhzVh9hLA&index=16&t=2534s
 */
class CalculateSumTest {

    @Test
    void calculateSum() {
        //123456789
        String input = "123456789";
        Integer sum =  CalculateSum.calculateSum(input);

        assertEquals(45, sum);
    }

    @Test
    void calculateSumStream() {
        //123456789
        String input = "123456789";
        Integer sum =  CalculateSum.calculateSumStream(input);

        assertEquals(45, sum);
    }
}