package hashing.hard;

import java.util.HashSet;
import java.util.Set;

public class AllUniqueTripleThatSumUpToGivenNum {

    private static final int []ARR = {0, -1, 2, -3, 1};

    public static void main(String[] args) {

        int sum = 0;

        printAllUniqueTriples(ARR, sum);

    }

    private static void printAllUniqueTriples(int[] arr, int sum) {

        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(s.contains(sum - (arr[i] + arr[j]))) {
                    System.out.println("Triple : (" + arr[i] + "," + arr[j] + "," + (sum - arr[i] - arr[j]) + ")");
                }
            }
            s.add(arr[i]);
        }
    }
}
