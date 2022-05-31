package hashing;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctElementInEveryWindow {

    public static void main(String[] args) {
      //  int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        int arr[] = new int[]{10, 10, 5, 3, 20, 5};

        ArrayUtils.printArray(arr, "Array is: ");

        int windowSize = 4;
        printDistinctElementInWindow1(arr, windowSize);
    }

    private static void printDistinctElementInWindow1(int[] arr, int windowSize) {

        for(int i = 0; i < arr.length - windowSize + 1; i++) {
            Set<Integer> s = new HashSet<>();
            for(int j = i; j < (i + windowSize); j++) {
                s.add(arr[j]);
            }
            System.out.println("Window " + i +" :- " + s.size());
        }
    }

    private static void printDistinctElementInWindow2(int[] arr, int windowSize) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < windowSize; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map.size());

        for(int i = windowSize; i < arr.length; i++) {
            map.put(arr[i - windowSize], map.get(arr[i - windowSize]) - 1);

            if(map.get(arr[i - windowSize]) == 0) {
                map.remove(arr[i - windowSize]);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.println(map.size());
        }
    }
}
