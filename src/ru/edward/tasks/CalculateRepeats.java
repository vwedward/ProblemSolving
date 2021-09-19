/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Решение задачи с собеседования Сулейманова
 * https://www.youtube.com/watch?v=StrgaxrAyyU&list=PLlsMRoVt5sTMMCwd_gLaaZMkQhzVh9hLA&index=14&t=313s
 */
//1,2,3,4,2,3,4,100
//[{1,1}, {2,2}, {3,2}...]
public class CalculateRepeats {

    public static Map<Integer, Integer> calculateRepeats(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty argument");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer el : input) {
            if (map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        }

        return map;
    }

    //Stream API (быдловатенько, но работает. Ниже попробую сделать получше)
    public static Map<Integer, Integer> calculateRepeatsStream(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty argument");
        }

        Map<Integer, Integer> map = new HashMap<>();
        input.stream().forEach(el -> {
            if (map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        });

        return map;
    }

    public static Map<Integer, Long> calculateRepeatsStreamPerfect(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty argument");
        }

        Map<Integer, Long> map = input.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        // Проблема 1 - Long вместо Integer
        // Проблема 2 - результат не в том порядке что предыдущие (см. юнит тест)
        return map;
    }

        /*
        Посмотреть такой вариант
        Map<String, Integer> phones = phoneStream.collect(Collectors.toMap(p->p.getName(), t->t.getPrice()));

        Отсюда https://habr.com/ru/post/337350/
        SELECT classifier, MAX(...) FROM ... GROUP BY classifier
        Есть другой замечательный коллектор — toMap, и это как раз то что надо. Мы просто хотим собрать элементы в Map,
        где ключом будет классификатор, а значением сам элемент. В случае же дубликата выберем больший из них.
        Для этого, кстати, есть BinaryOperator.maxBy(comparator), который можно статически импортировать вместо
        одноимённого коллектора. В результате имеем: toMap(classifier, identity(), maxBy(comparator)).

         */

}
