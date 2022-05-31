package hashing;

import utils.ArrayUtils;

import java.util.Map;
import java.util.TreeMap;

public class CountFrequencyOfElementInArray {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        ArrayUtils.printArray(arr, "Array Elements:- ");

        countFrequency(arr);
    }

    private static void countFrequency(int[] arr) {

        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map);
    }
}
