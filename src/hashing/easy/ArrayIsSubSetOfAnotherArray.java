package hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class ArrayIsSubSetOfAnotherArray {

    private static final int []arr1 = {10,20,30,40,50};
    private static final int []arr2 = {20,50,40};

    public static void main(String[] args) {

        boolean isSubSet = checkIfSubSet(arr1, arr2);
        System.out.println(isSubSet);
    }

    private static boolean checkIfSubSet(int[] arr1, int[] arr2) {
        Set<Integer> s = new HashSet<>();
        for(int i : arr1) {
            s.add(i);
        }
        for(int i : arr2) {
            if (!s.contains(i))
                return false;
        }

        return true;
    }
}
