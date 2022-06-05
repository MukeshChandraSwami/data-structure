package hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class MinimumDeleteOperationRequiredToMakeArrayElementsSame {

    private static final int[] arr = {4, 3, 4, 4, 2, 4};

    public static void main(String[] args) {
        int minElements = countMinElementsToDelete(arr);
        System.out.println(minElements);
    }

    private static int countMinElementsToDelete(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = Integer.MAX_VALUE;
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e :  map.entrySet()) {
            count = Math.min(count, arr.length - e.getValue());
        }

        return count;
    }
}
