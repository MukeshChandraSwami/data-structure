package recursion.v2;


import utils.ArrayUtils;

public class CheckIfElementPresentInArray {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        int element = 10;
        boolean isPresent = checkIfElementIsPresentByIndexParam(arr, element, 0);
        ArrayUtils.printArray(arr, "Array Is:- ");
        System.out.println("\n isPresent :- " +  isPresent);

        isPresent = checkIfElementIsPresentBySizeParam(arr, element, arr.length);
        System.out.println("\n isPresent :- " +  isPresent);
    }

    private static boolean checkIfElementIsPresentByIndexParam(int[] arr, int element, int index) {
        // Base conditions.
        if(arr.length == index)
            return false;

        // Calculation/operation
        if(arr[index] == element)
            return true;

        // Solving smaller problems
        return checkIfElementIsPresentByIndexParam(arr, element, index + 1);
    }

    private static boolean checkIfElementIsPresentBySizeParam(int[] arr, int element, int size) {
        if(size == 0)
            return false;

        if(arr[size - 1] == element)
            return true;

        return checkIfElementIsPresentBySizeParam(arr, element, size - 1);
    }
}
