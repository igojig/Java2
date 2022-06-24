package lesson_3.task_1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] strArray = {
                "6-Test",
                "4-AAA",
                "4-AAA",
                "4-AAA",
                "4-AAA",
                "8-BB",
                "8-BB",
                "8-BB",
                "8-BB",
                "8-BB",
                "8-BB",
                "8-BB",
                "6-Test",
                "6-Test",
                "6-Test",
                "6-Test",
                "1-QQQQQ",
                "2-Z",
                "2-Z",
                "6-Test",
                "1-LLLL",
                "8-BB"

        };
        /*String[] strArray={
                "A",
                "B",
                "C",
                "B"
        };*/


        variant1(strArray);
        variant2(strArray);
        variant3(strArray);

    }

    //вариант 1
    private static void variant1(String[] strArray) {
        System.out.println("Вариант 1");

        Map<String, Integer> map = new HashMap<>();
        for (String s : strArray) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.printf("word: %5s - %s times\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

        System.out.println();

        System.out.println("Unique words:");
        System.out.println(map.keySet());
        System.out.println();


    }

    //вариант 2
    private static void variant2(String[] strArray) {
        System.out.println("Вариант 2");
        Map<String, Integer> map = new HashMap<>();
        for (String s1 : strArray) {
            map.merge(s1, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.printf("word: %5s - %s times\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

        System.out.println();

        System.out.println("Unique words:");
        System.out.println(map.keySet());
        System.out.println();
    }

    //вариант 3
    private static void variant3(String[] strArray) {
        System.out.println("Вариант 3");
        //как работает эта дичь, я понимаю с трудом...
        Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((str, i) -> System.out.printf("word: %5s - %s times\n", str, i));

        System.out.println();

        System.out.println("Unique words:");
        System.out.println(Arrays.stream(strArray)
                .distinct()
                .collect(Collectors.joining(", ", "[", "]")));
    }
}
