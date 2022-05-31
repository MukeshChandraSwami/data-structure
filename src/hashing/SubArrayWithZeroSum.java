package hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {

    private static final int []ARR = { 12,3,5,4,-2,-1,-1, 16 };

    public static void main(String[] args) {

        boolean isSubArrayExists = checkSubArrayForZeroSum(ARR);
        System.out.println(isSubArrayExists);
    }

    private static boolean checkSubArrayForZeroSum(int[] arr) {

        Set<Integer> s = new HashSet<>();

        int sum = 0;
        for(int i : arr) {
            sum += i;
            if(s.contains(sum) || sum == 0 || i == 0) {
                return true;
            }
            s.add(sum);
        }
        return false;
    }
}
