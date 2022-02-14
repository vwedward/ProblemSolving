/*
 * ©Edward, 2022
 */

package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Решение тестовой задачи компании Gridnine systems
 * Постановка задачи.
 *
 * Имеется некая система, которая обрабатывает авиа перелёты. Перелёт — это перевозка пассажира
 * из одной точки в другую с возможными промежуточными посадками. Т. о. перелёт можно представить
 * как набор из одного или нескольких элементарных перемещений, называемых сегментами.
 *
 * Сегмент — это атомарная перевозка, которую для простоты будем характеризовать всего двумя атрибутами:
 * дата/время вылета и дата/время прилёта.
 *
 * Вам нужно написать небольшой модуль, который будет заниматься фильтрацией набора перелётов согласно различным правилам.
 * Правил фильтрации может быть очень много. Также наборы перелётов могут быть очень большими.
 * Правила могут выбираться и задаваться динамически в зависимости от контекста выполнения операции фильтрации.
 * Продумайте структуру модуля, создайте необходимые классы и интерфейсы. Если знакомы с Junit, то покройте свой код тестами.
 * Пользовательский интерфейс не рассматривайте. Достаточно вывода информации в консоль. Никаких сторонних библиотек использовать не нужно.
 * Приложенный файл TestClasses.java содержит упрощённые модельные классы и фабрику для получения тестовых образцов.
 * Весь код необходимо поместить в пакет com.gridnine.testing
 * Для проверочного запуска создайте публичный класс Main c методом main()
 * Этот метод должен выдать в консоль результаты обработки тестового набора перелётов.
 * Получить тестовый набор нужно методом FlightBuilder.createFlights()
 * Поместите в main() такой проверочный код. Исключите из тестового набора перелёты по следующим правилам
 * (по каждому правилу нужен отдельный вывод списка перелётов):
 * 1.	вылет до текущего момента времени
 * 2.	имеются сегменты с датой прилёта раньше даты вылета
 * 3.	общее время, проведённое на земле превышает два часа
 *      (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
 */

interface Filter {
    boolean Test(Flight flight);
}

class Filter1 implements Filter {
    @Override
    public boolean Test(Flight flight) {
        return flight.getSegments().stream().noneMatch(o -> o.getDepartureDate().compareTo(LocalDateTime.now()) < 0);
    }
}

class Filter2 implements Filter {
    @Override
    public boolean Test(Flight flight) {
        return flight.getSegments().stream().noneMatch(o -> o.getDepartureDate().compareTo(o.getArrivalDate()) > 0);
    }
}

class Filter3 implements Filter {
    @Override
    public boolean Test(Flight flight) {
        Segment prevSegment = null;
        long groundTimeInMin = 0;

        for (Segment segment: flight.getSegments()) {
            if (prevSegment != null) {
                //Подсчет времени нахождения на земле с точностью до минуты
                groundTimeInMin += prevSegment.getArrivalDate().until(segment.getDepartureDate(), ChronoUnit.MINUTES);
            }
            prevSegment = segment;
        }
        return groundTimeInMin < 2*60; //2 часа
    }
}

class FlightFilterService {
    private final List<Flight> flightList;
    private List<Filter> filterList;

    public FlightFilterService(final List<Flight> flightList) {
        this.flightList = flightList;
        filterList = new ArrayList<>();
    }

    public List<Filter> getFilterList() {
        return filterList;
    }

    public List<Flight> filter(Integer filterIndex) {
        Filter f = filterList.get(filterIndex);
        return flightList.stream().filter(f::Test).collect(Collectors.toList());
    }

    public void filterAndPrint(Integer filterIndex) {
        if (filterIndex < 0 || filterIndex >= filterList.size()) {
            throw new IllegalArgumentException("Недопустимый номер фильтра");
        };
        System.out.println(filter(filterIndex));
    }
}

public class Main {
    public static void main(String[] args) {
        //Инициализируем filterService и динамически добавляем в него фильтры
        FlightFilterService flightFilterService = new FlightFilterService(FlightBuilder.createFlights());
        flightFilterService.getFilterList().add(new Filter1());
        flightFilterService.getFilterList().add(new Filter2());
        flightFilterService.getFilterList().add(new Filter3());

        //Вывод трёх выборок по ТЗ
        flightFilterService.filterAndPrint(0);
        flightFilterService.filterAndPrint(1);
        flightFilterService.filterAndPrint(2);
    }
}
