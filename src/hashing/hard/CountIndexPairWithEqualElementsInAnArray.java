package hashing.hard;

import java.util.HashMap;
import java.util.Map;

public class CountIndexPairWithEqualElementsInAnArray {

    private static final int []arr = {1, 1, 1, 2, 1};

    public static void main(String[] args) {

        int count = getCount(arr);
        System.out.println(count);
    }

    private static int getCount(int[] arr) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int i : map.keySet()) {
            int v = map.get(i);
            result += (v * (v - 1)) / 2;
        }

        return result;
    }
}
