package utils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayUtils {

    public enum ArrayTypeBySizeAndRotation {
        BALANCED, LEFT_SKEWED, RIGHT_SKEWED;
    }

    private static int[] ARR = {2,1,3,2,4,0,3,2,1,0,5,7,3,8,3,9,0,4,5};

    private static int[] PALINDROME_ARR = {1,2,3,4,5,4,3,2,1};

    private static int[] NEG_AND_POS_NUM_ARR = {-1,2,3,-4,5,8,-6,9,-10};

    /*********** UTILITY FUNCTIONS FOR ARRAY ***********/

    public static int[] getUnsortedIntegerArrayWithSmallNumbers() {
        return ARR;
    }

    public static int[] getSortedIntegerArrayWithSmallNumbers() {

        return getSortedArr(ARR, false);
    }

    public static int[] getSortedUniqueIntegerArrayWithSmallNumbers() {

        return getSortedArr(ARR, true);
    }

    public static int[] getNegAndPosNumArr() {
        return NEG_AND_POS_NUM_ARR;
    }

    public static int[] getPalindromeArr() {
        return PALINDROME_ARR;
    }

    public static int[] getUnsortedRandomIntegerArray() {
        return getRandomArray(false, 15);
    }

    public static int[] getUnsortedRandomIntegerArrayOfGivenSize(int size) {
        return getRandomArray(false, size);
    }

    public static int[] getSortedRandomIntegerArray() {
        return getRandomArray(true, 15);
    }

    public static int[] getSortedRandomIntegerArrayOfGivenSize(int size) {
        return getRandomArray(true, size);
    }

    public static void printArray(int[] arr, String msg) {
        System.out.print(msg + " :- ");
        Arrays.stream(arr)
                .forEach(i -> System.out.print(i + "\t"));
        System.out.println();
    }

    public static ArrayTypeBySizeAndRotation arrayTypeBySizeAndRotation(int size, int rotation) {
        int div = size / 2;
        if(rotation < div) {
            return ArrayTypeBySizeAndRotation.LEFT_SKEWED;
        } else if(rotation > div) {
            return ArrayTypeBySizeAndRotation.RIGHT_SKEWED;
        }

        return ArrayTypeBySizeAndRotation.BALANCED;
    }

    public static int[] rotateArray(int []arr, int rotate) {
        int[] rotatedArr = new int[arr.length];
        int j = rotate;
        int i = 0;
        for(; rotate < arr.length; i++) {
            rotatedArr[i] = arr[rotate++];
        }

        for(int k = 0; k < j; k++, i++) {
            rotatedArr[i] = arr[k];
        }
        return rotatedArr;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int[] getSequentialSortedArray(int limit) {
        return IntStream.rangeClosed(1, limit)
                .toArray();
    }

    private static int[] getRandomArray(boolean sorted, int size) {
        int[] intArray = IntStream.generate(() -> new Random().nextInt(100)).limit(size).toArray();
        return sorted ? getSortedArr(intArray, false) : intArray;
    }

    private static int[] getSortedArr(int[] arr, boolean distinct) {
        IntStream intStream = Arrays.stream(arr).sorted();
        return distinct ? intStream.distinct().toArray() : intStream.toArray();
    }
}
