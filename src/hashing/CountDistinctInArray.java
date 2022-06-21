package hashing;

import java.util.HashSet;
import java.util.Set;

import static utils.ArrayUtils.getPalindromeArr;

public class CountDistinctInArray {

    public static void main(String[] args) {
        int []arr = getPalindromeArr();
        int count = countDistinctElementsInArr(arr);
        System.out.println(count);
    }

    private static int countDistinctElementsInArr(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        return set.size();
    }
}
