package hashing.intermediate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestIncreasingConsecutiveSubSequence {

    private static final int[] ARR = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12};

    public static void main(String[] args) {

        System.out.println(getLength1(ARR));
        System.out.println(getLength2(ARR));
    }

    private static int getLength1(int[] arr) {
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

    private static int getLength2(int []arr) {
        Set<Integer> s = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());


        int res = 0;
        for(int i : s) {
            if(!s.contains(i - 1)) {
                int len = 1;
                while (s.contains(i + 1)) {
                    len += 1;
                    i = i + 1;
                }

                res = Math.max(res, len);
            }
        }

        return res;
    }
}
