package hashing.intermediate;

import java.util.HashMap;
import java.util.Map;

public class TwoOrMorePairsWithEqualSum {

    private static final int[] ARR = {3, 4, 7, 1, 2, 9, 8};

    public static void main(String[] args) {
        printPair(ARR);
    }

    private static void printPair(int[] arr) {

        Map<Integer, String> pairs = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                freq.put(sum, freq.getOrDefault(sum, 0) + 1);
                pairs.put(sum, (pairs.getOrDefault(sum, "") + "(" +arr[i] + "," + arr[j] + ")"));
            }
        }

        for(int i : freq.keySet()) {
            if(freq.get(i) > 1) {
                System.out.println(pairs.get(i));
            }
        }
    }
}
