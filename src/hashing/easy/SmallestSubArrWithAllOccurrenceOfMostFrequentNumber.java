package hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubArrWithAllOccurrenceOfMostFrequentNumber {

    private static final int arr[] = {4, 1, 1, 2, 2, 3, 3, 2, 3, 1};

    public static void main(String[] args) {

        printSubArray(arr);
    }

    private static void printSubArray(int[] arr) {

        Map<Integer, Integer> startingIndex = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        int highestFreq = 0;
        int left = 0;
        int right = 0;

        for(int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if(!startingIndex.containsKey(v)) {
                startingIndex.put(v, i);
            }

            frequency.put(v , frequency.getOrDefault(v, 0) + 1);

            if(frequency.get(v) >= highestFreq) {
                highestFreq = frequency.get(v);
                left = startingIndex.get(v);
                right = i;
            } else if(frequency.get(v) == highestFreq && ((right - left) > (i - startingIndex.get(v)))) {
                highestFreq = frequency.get(v);
                left = startingIndex.get(v);
                right = i;
            }
        }

        for(int i = left; i <= right; i++) {
            System.out.println(arr[i]);
        }
    }
}
