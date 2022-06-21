package hashing;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyOfElementInArray {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        ArrayUtils.printArray(arr, "Array Elements:- ");

        countFrequency(arr);
    }

    private static void countFrequency(int[] arr) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        System.out.println("Type 1: " + map);

        Map<Integer, Long> m = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Type 2: " + m);
    }
}
