package hashing;

import utils.ArrayUtils;

import java.util.Set;
import java.util.TreeSet;

public class UnionOf2Array {

    public static void main(String[] args) {
        int[] arr1 = ArrayUtils.getSequentialSortedArray(10);
        int[] arr2 = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();

        ArrayUtils.printArray(arr1, "Array1:- ");
        ArrayUtils.printArray(arr2, "Array2:- ");

        Set<Integer> ls = getUnionElements(arr1, arr2);
        System.out.println(ls);
    }

    private static Set<Integer> getUnionElements(int[] arr1, int[] arr2) {
        Set<Integer> s = new TreeSet<>();
        for (int i : arr1) {
            s.add(i);
        }

        for (int i : arr2) {
            s.add(i);
        }

        return s;
    }
}
