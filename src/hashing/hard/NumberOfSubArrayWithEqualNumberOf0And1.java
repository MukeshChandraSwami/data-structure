package hashing.hard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArrayWithEqualNumberOf0And1 {

    private static int[] ARR = { 1, 0, 0, 1, 0, 1, 1 };

    public static void main(String[] args) {

        int count = getSubArrayCount(ARR);
        System.out.println(count);
    }

    private static int getSubArrayCount(int[] arr) {

        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] == 0) {
                arr[i] = -1;
            }

            sum += arr[i];

            count = sum == 0 ? count + 1 : count;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
