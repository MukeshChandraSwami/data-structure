package hashing;

public class LongestSpanWithWithSameSumInBinaryArray {

    private static final int []ARR1 = {0, 1, 0, 1, 1, 1, 1};
    private static final int []ARR2 = {1, 1, 1, 1, 1, 0, 1};

    public static void main(String[] args) {

        int len = getLength(ARR1, ARR2);
        System.out.println(len);
    }

    private static int getLength(int[] arr1, int[] arr2) {
        int []arr = new int[arr1.length];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i] - arr2[i];
        }
        return LongestSubArrayLengthWithGivenSum.getLength(arr, 0);
    }
}
