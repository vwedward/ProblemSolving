/*
 * ©Edward, 2022
 */

package ru.edward.forward;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Решение тестовой задачи 2 компании Forward telecom
 *
 * Имеется Map, в котором ключи – строки, а значения – списки(List) целых чисел.
 * Требуется развернуть этот Map в список целых чисел, при этом значения должны добавляться
 * в соответствии с алфавитным порядком ключей. Следует использовать java 8 streams.
 *
 * Пример входных данных:
 * "a": {1, 2, 3}
 * "c": {6, 7, 8}
 * "b": {4, 5}
 * Пример возвращаемого значения: {1, 2, 3, 4, 5, 6, 7, 8}
 */

public class ForwardTestTask2 {
    public static List<Integer> mapToList(Map<String, List<Integer>> map) {
        return map.entrySet().stream().sorted((o1, o2) -> (o1.getKey().compareTo(o2.getKey()))).flatMap((t->t.getValue().stream())).collect(Collectors.toList());
        //sorted((o1, o2) -> (o1.getKey().compareTo(o2.getKey())))
        //sorted((o1, o2) -> (o2.getKey().compareTo(o1.getKey())))
        //sorted((o1, o2) -> (o2.getKey().length() - o1.getKey().length()))
    }
    public static void main(String[] args) {
        Map<String, List<Integer>> m = new HashMap<>();
        m.put("a", Arrays.asList(1, 2, 3));
        m.put("c", Arrays.asList(6, 7, 8));
        m.put("b", Arrays.asList(4, 5));

        List<Integer> res = mapToList(m);

        res.stream().forEach(System.out::println); //x -> System.out.println(x)

//        for (Integer i: res) {
//            System.out.println(i);
//        }
    }
}
