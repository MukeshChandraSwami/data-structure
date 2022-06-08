package hashing.hard;

import java.util.HashMap;
import java.util.Map;

public class SumOfAllUniqueSubArraySum {

    private static final int []ARR = {2,4,2};

    public static void main(String[] args) {

        int sum = getSum(ARR);
        System.out.println(sum);
    }

    private static int getSum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {

            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int sum = 0;
        for(int i : map.keySet()) {
            sum = map.get(i) == 1 ? sum + i : sum;
        }
        return sum;
    }
}
