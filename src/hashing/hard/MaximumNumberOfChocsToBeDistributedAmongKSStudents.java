package hashing.hard;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfChocsToBeDistributedAmongKSStudents {

    private static int []ARR = {2, 7, 6, 1, 4, 9, 5};

    public static void main(String[] args) {
        int k = 3;

        int count = getChocolateCount(ARR, k);
        System.out.println(count);
    }

    private static int getChocolateCount(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int len = 0;
        int preSum = 0;
        int chocoCount = 0;

        for(int i = 0; i < arr.length; i++) {

            preSum += arr[i];

            if(preSum % k == 0) {
                start = 0;
                len = i;
            }

            if(map.containsKey(preSum % k)) {
                int s = map.get(preSum % k);
                len = Math.max(len, (i - s));
                start = s + 1;
            } else {
                map.put(preSum, i);
            }
        }

        for(int i = start; i <= len; i++) {
            chocoCount += arr[i];
        }

        return chocoCount / k;
    }
}
