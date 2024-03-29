package hashing;

public class LongestSubArrayWithEqualNumOf0And1 {

    private static int []ARR = {0, 1, 1, 0, 1, 1};

    public static void main(String[] args) {

        int len = countLength(ARR);
        System.out.println(len);
    }

    private static int countLength(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                arr[i] = -1;
        }

        return LongestSubArrayLengthWithGivenSum.getLength(arr, 0);
        //return LongestSubArrayLengthWithGivenSum.getLength(arr, 1);       // Longest sub array, who count of 1 == count of 0 + 1
    }
}
