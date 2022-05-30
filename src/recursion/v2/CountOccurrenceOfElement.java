package recursion.v2;

import array.ArrayUtils;

public class CountOccurrenceOfElement {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        ArrayUtils.printArray(arr, "Array is:- ");
        int element = 10;
        int counter = countOccurrence(arr, element, 0);
        System.out.println(counter);
    }

    private static int countOccurrence(int[] arr, int element, int index) {
        if(arr.length == index)
            return 0;

        int s = countOccurrence(arr, element, index + 1);

        return arr[index] == element ? s+1 : s;
    }
}
