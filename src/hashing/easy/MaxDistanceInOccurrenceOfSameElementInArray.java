package hashing.easy;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class MaxDistanceInOccurrenceOfSameElementInArray {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.getPalindromeArr();
        ArrayUtils.printArray(arr, "Array is");

        int maxDistance = getMaxDistance(arr);
        System.out.println(maxDistance);
    }

    private static int getMaxDistance(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        int distance = 0;

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                distance = Math.max(distance, i - map.get(arr[i]));
            } else {
                map.put(arr[i], i);
            }
        }

        return distance;
    }
}
