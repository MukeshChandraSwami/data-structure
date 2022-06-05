package hashing.intermediate;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumDivisibleByK {

    private static final int ARR[] = {2, 7, 6, 1, 4, 5};

    public static void main(String[] args) {

        int k = 3;
        int len = getLengthOfLongestSubArray(ARR, k);
        System.out.println(len);
    }

    private static int getLengthOfLongestSubArray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int mod = ((sum % k) + k) % k;

            if(mod == 0)
                res = i + 1;

            if(!map.containsKey(mod)) {
                map.put(mod, i);
            } else {
                int size = i - map.get(mod);
                res = Math.max(size, res);
            }
        }

        return res;
    }
}
