package hashing.intermediate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PairOfArrayElementsAreDivisibleByK {

    private static final int[] ARR = {9, 7, 5, 3, 6, 7};

    public static void main(String[] args) {

        int k = 6;

        boolean flag = checkIfDivisibleByK(ARR, k);
        System.out.println(flag);
    }

    private static boolean checkIfDivisibleByK(int[] arr, int k) {
        if(arr.length % 2 != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        if(freq.containsKey(0) && freq.get(0) % 2 != 0) {
            return false;
        }

        freq.remove(0);

        for(int key : freq.keySet()) {

            int kKey = k - key;

            if(!freq.containsKey(kKey) || !Objects.equals(freq.get(key), freq.get(kKey)))
                return false;
        }

        return true;
    }
}
