package hashing.intermediate;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DivisibleByOneOther {

    public static void main(String[] args) {

        int[] arr = {2, 3, 8, 6, 9, 10};
        Arrays.sort(arr);
        ArrayUtils.printArray(arr, "Arrays is");
        printElements(arr);
    }

    private static void printElements(int[] arr) {

        Set<Integer> s = new HashSet<>();

        for (int i : arr) {
            s.add(i);
        }

        for(int j = arr.length - 1; j >= 0; j--) {

            if(arr[j] == 0)
                continue;

            for(int i = 2; i < Math.sqrt(arr[j]); i++) {

                if(arr[j] % i == 0) {
                    int factor2 = arr[j]/i;
                    if(s.contains(i) || s.contains(factor2)) {
                        System.out.println(arr[j]);
                        break;
                    }
                }
            }
        }
    }
}
