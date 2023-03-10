package me.ola.webapps.webTesting;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> list = new Random().
                ints(0, 100).
                limit(10).
                boxed().
                collect(Collectors.toList());
        System.out.println(list);

        findMinMax(list.stream(),
                Integer::compareTo,
                ((x, y) -> System.out.println("min " + x + " max " + y)));

        searchEvenNumFirst(list);
        searchEvenNumSecond(list);
    }
    public static <T> void findMinMax (
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> tList = stream.sorted(order).collect(Collectors.toList());

        if (!tList.isEmpty()) {
            minMaxConsumer.accept(tList.get(0), tList.get(tList.size() - 1));
        } else {

            minMaxConsumer.accept(null, null);
        }
    }

    public static void searchEvenNumFirst(List<Integer> integerList) {

        List<Integer> evenNumlist = integerList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("count of even numbers: " + evenNumlist.size() + "; numbers " + evenNumlist);
    }

    public static void searchEvenNumSecond(List<Integer> integerList) {
        System.out.println(integerList.stream().
                filter(x -> x % 2 == 0).
                peek(x -> System.out.print("[" + x + "]" + ",")).
                count());
    }

    }