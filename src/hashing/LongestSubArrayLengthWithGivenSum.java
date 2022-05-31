package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayLengthWithGivenSum {

    private static final int[] ARR = {8, 3, 1, 5, -6, 6, 2, 2};

    public static void main(String[] args) {

        int sum = 4;
        int len = getLength(ARR, sum);
        System.out.println(len);
    }

    public static int getLength(int[] arr, int sum) {
        int len = 0;
        int pre_sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            pre_sum += arr[i];

            if(sum == pre_sum)
                len = i + 1;

            if(!map.containsKey(pre_sum))
                map.put(pre_sum, i);

            if(map.containsKey(pre_sum - sum))
                len = Math.max(len, i - map.get(pre_sum - sum));

        }

        return len;
    }
}
