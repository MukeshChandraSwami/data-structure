package recursion.v2;

import array.ArrayUtils;

public class PrintAllPositionsOfElement {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        ArrayUtils.printArray(arr, "Array is:- ");
        int element = 3;

        printAllPositions(arr, element, 0);
    }

    private static void printAllPositions(int[] arr, int element, int index) {
        if(index == arr.length)
            return;
        
        if(arr[index] == element)
            System.out.println(index);

        printAllPositions(arr, element, index + 1);
    }
}
