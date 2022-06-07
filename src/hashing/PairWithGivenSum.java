package hashing;

import utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

    public static void main(String[] args) {

        int sum = 11;
        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        ArrayUtils.printArray(arr,"Array");

        printPair(arr, sum);
    }

    private static void printPair(int[] arr, int sum) {

        Set<Integer> s = new HashSet<>();
        for(int i : arr) {
            int v = sum - i;
            if(s.contains(v)) {
                System.out.println("(" + v + "," + i + ")");
            } else {
                s.add(i);
            }
        }
    }
}
