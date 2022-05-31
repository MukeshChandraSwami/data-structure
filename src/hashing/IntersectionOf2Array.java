package hashing;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Common Elements in array
public class IntersectionOf2Array {

    public static void main(String[] args) {
        int[] arr1 = ArrayUtils.getSequentialSortedArray(10);
        int[] arr2 = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();

        ArrayUtils.printArray(arr1, "Array1:- ");
        ArrayUtils.printArray(arr2, "Array2:- ");

        List<Integer> ls = getIntersectionElements(arr1, arr2);
        System.out.println(ls);
    }

    private static List<Integer> getIntersectionElements(int[] arr1, int[] arr2) {
        List<Integer> ls = new ArrayList<>();

        Set<Integer> s = new HashSet<>();
        for (int i : arr1) {
            s.add(i);
        }

        for (int i : arr2) {
            if (s.contains(i)) {
                ls.add(i);
                s.remove(i);
            }
        }

        return ls;
    }
}
