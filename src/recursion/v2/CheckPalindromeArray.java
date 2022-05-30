package recursion.v2;

import array.ArrayUtils;

public class CheckPalindromeArray {

    public static void main(String[] args) {

        int[] palindromeArr = ArrayUtils.getPalindromeArr();
        ArrayUtils.printArray(palindromeArr,"Array is:- ");

        boolean isPalindrome = checkIfPalindromeArray(palindromeArr, 0, palindromeArr.length);
        System.out.println(isPalindrome);
    }

    private static boolean checkIfPalindromeArray(int[] palindromeArr, int index, int size) {
        if(size <= index) {
            return true;
        }

        if(palindromeArr[index] != palindromeArr[size-1]) {
            return false;
        }

        return checkIfPalindromeArray(palindromeArr, index + 1, size - 1);
    }
}
