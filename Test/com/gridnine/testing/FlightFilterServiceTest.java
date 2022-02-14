/*
 * ©Edward, 2022
 */

package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Тесты задачи компании Gridnine systems
 */
class FlightFilterServiceTest {
    FlightFilterService flightFilterService;

    @BeforeEach
    void setUp() {
        flightFilterService = new FlightFilterService(FlightBuilder.createFlights());
        flightFilterService.getFilterList().add(new Filter1());
        flightFilterService.getFilterList().add(new Filter2());
        flightFilterService.getFilterList().add(new Filter3());
    }

    @Test
    void filter1() {
        //Примечание. Такой способ проверки фильтра грубоват, однако при необходимости можно сделать и поточнее
        assertEquals(5, flightFilterService.filter(0).size());
    }

    @Test
    void filter2() {
        assertEquals(5, flightFilterService.filter(1).size());
    }

    @Test
    void filter3() {
        assertEquals(4, flightFilterService.filter(2).size());
    }
}