package recursion.v2;

import array.ArrayUtils;

public class SumOfArray {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getSortedRandomIntegerArrayOfGivenSize(3);
        ArrayUtils.printArray(arr, "Arrays is:- ");
        int sum = getSumOfArrayElementsByIndexing(arr, 0);
        System.out.println("\nSum :- " + sum);

        sum = getSumOfArrayElementsByArraySizing(arr, arr.length);
        System.out.println("\nSum :- " + sum);
    }

    private static int getSumOfArrayElementsByArraySizing(int[] arr, int length) {
        // Base case
        if(length == 0) {
            return 0;
        }

        // Solving small problems     +    operations
        return getSumOfArrayElementsByArraySizing(arr, length - 1) + arr[length - 1];
    }

    private static int getSumOfArrayElementsByIndexing(int[] arr, int index) {
        // Base cases
        if(arr.length == 0 || index == arr.length) {
            return 0;
        }

        // Solving small problems
        int s = getSumOfArrayElementsByIndexing(arr, index + 1);

        // calculation
        return s + arr[index];
    }
}
