package recursion.v2;

import array.ArrayUtils;

public class CheckSortedArray {

    public enum SortingStrategy {
        AESC, DESC
    }

    public static void main(String[] args) {
        var sortedRandomIntegerArrayOfGivenSize = ArrayUtils.getSortedRandomIntegerArrayOfGivenSize(5);
        ArrayUtils.printArray(sortedRandomIntegerArrayOfGivenSize, "Arrays is:- ");
        boolean isSorted = checkIfArrayIsSorted(sortedRandomIntegerArrayOfGivenSize, SortingStrategy.AESC, 0);
        System.out.println(isSorted);

        isSorted = checkIfArrayIsSorted(sortedRandomIntegerArrayOfGivenSize, sortedRandomIntegerArrayOfGivenSize.length, SortingStrategy.AESC);
        System.out.println(isSorted);
    }

    /**
     * This method check for sorted array.
     * Here we increment index one by one and validate with next index.
     * @param arr
     * @param sortStrategy
     * @param index
     * @return
     */
    private static boolean checkIfArrayIsSorted(int[] arr, SortingStrategy sortStrategy, int index) {

        // Base condition
        if(index + 1 >= arr.length) {
            return true;
        }

        // Solving smaller problems
        boolean isSorted = checkIfArrayIsSorted(arr, sortStrategy, index + 1);

        // Calculation
        return isSorted && (sortStrategy ==  SortingStrategy.AESC ? arr[index] < arr[index + 1] : arr[index] > arr[index + 1]);
    }

    private static boolean checkIfArrayIsSorted(int[] arr, int size, SortingStrategy sortStrategy) {

        // Base condition
        if(arr.length <= 1 || size == 1)
            return true;

        // Solving smaller problems.
        boolean s = checkIfArrayIsSorted(arr, size -1, sortStrategy);

        // Calculations.
        return s && (sortStrategy == SortingStrategy.AESC ? arr[size-2] < arr[size-1] : arr[size-2] > arr[size-1]);
    }
}
