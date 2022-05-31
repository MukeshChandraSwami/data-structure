package hashing;

import utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubSequence {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        ArrayUtils.printArray(arr, "Array is:- ");

        int len = getLength(arr);
        System.out.println(len);
 
    }

    private static int getLength(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for(int i : arr) {
            s.add(i);
        }

        int current = 1;
        int len = 1;

        for(Integer i : s) {
            if(!s.contains(i - 1)) {
                while (s.contains(i + 1)) {
                    i += 1;
                    current += 1;
                }
            }

            len = Math.max(current, len);
            current = 1;
        }

        return len;
    }
}
