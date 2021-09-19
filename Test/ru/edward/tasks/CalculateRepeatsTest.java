/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Решение задачи с собеседования Сулейманова
 * https://www.youtube.com/watch?v=StrgaxrAyyU&list=PLlsMRoVt5sTMMCwd_gLaaZMkQhzVh9hLA&index=14&t=313s
 */
class CalculateRepeatsTest {

    @Test
    void calculateRepeats() {
        //1, 2, 3, 4, 2, 3, 4, 100
        //[{1,1}, {2,2}, {3,2}...]
        List<Integer> inp = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 100);
        Map<Integer, Integer> map = CalculateRepeats.calculateRepeats(inp);

        assertEquals(map.toString(), "{1=1, 2=2, 3=2, 4=2, 100=1}");
    }

    @Test
    void calculateRepeatsStream() {
        //1, 2, 3, 4, 2, 3, 4, 100
        //[{1,1}, {2,2}, {3,2}...]
        List<Integer> inp = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 100);
        Map<Integer, Integer> map = CalculateRepeats.calculateRepeatsStream(inp);

        assertEquals(map.toString(), "{1=1, 2=2, 3=2, 4=2, 100=1}");
    }

    @Test
    void calculateRepeatsStreamPerfect() {
        //1, 2, 3, 4, 2, 3, 4, 100
        //[{1,1}, {2,2}, {3,2}...]
        List<Integer> inp = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 100);
        Map<Integer, Long> map = CalculateRepeats.calculateRepeatsStreamPerfect(inp);

        assertEquals(map.toString(), "{1=1, 2=2, 3=2, 100=1, 4=2}");
    }
}