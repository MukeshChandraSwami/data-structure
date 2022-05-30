package recursion.v2;

import array.ArrayUtils;

public class FirstIndexOfElement {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getUnsortedIntegerArrayWithSmallNumbers();
        int element = 3;
        ArrayUtils.printArray(arr, "Arrays:- ");
        int index = getFirstIndexOfElement(arr, element, 0);
        System.out.println("\n First Index:- " + index);
    }

    private static int getFirstIndexOfElement(int[] arr, int element, int index) {
        if(index == arr.length)
            return -1;

        if(arr[index] == element)
            return index;

        return getFirstIndexOfElement(arr, element, index + 1);
    }
}
