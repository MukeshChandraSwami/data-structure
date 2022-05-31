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
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }
}
