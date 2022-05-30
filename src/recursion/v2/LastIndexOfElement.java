package recursion.v2;

import array.ArrayUtils;

public class LastIndexOfElement {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.getSortedIntegerArrayWithSmallNumbers();
        int element = 3;
        ArrayUtils.printArray(arr, "Arrays:- ");
        int index = getLastIndexOfElementViaIndexParam(arr, element, 0);
        System.out.println("\n Last Index:- " + index);

        index = getLastIndexOfElementBySizeParam(arr, element, arr.length);
        System.out.println("\n Last Index:- " + index);
    }

    private static int getLastIndexOfElementViaIndexParam(int[] arr, int element, int index) {
        if(index == arr.length)
            return -1;

        int i = arr[index] == element ? index : -1;
        int lastIndex = getLastIndexOfElementViaIndexParam(arr, element, index + 1);
        return Math.max(i, lastIndex);

        //return Math.max(arr[index] == element ? index : -1, getLastIndexOfElementViaIndexParam(arr, element, index + 1));
    }

    private static int getLastIndexOfElementBySizeParam(int[] arr, int element, int size) {
        if(size == 0)
            return -1;

        if(arr[size - 1] == element)
            return size - 1;

        return getLastIndexOfElementBySizeParam(arr, element, size - 1);
    }
}
