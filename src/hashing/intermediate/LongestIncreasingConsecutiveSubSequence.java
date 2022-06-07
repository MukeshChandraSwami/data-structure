package hashing.intermediate;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingConsecutiveSubSequence {

    private static final int[] ARR = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12};

    public static void main(String[] args) {

        int len = getLength(ARR);
        System.out.println(len);
    }

    private static int getLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int res = 0;

        for(int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int index = map.get(key);
            int maxLen = 1;
            while(map.containsKey(key+1) && map.get(key+1) > index) {
                index = map.get(key+1);
                key += 1;
                maxLen += 1;
            }

            res = Math.max(res, maxLen);
        }

        return res;
    }
}
