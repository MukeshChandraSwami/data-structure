package hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {

    private static final int []ARR = { 12,3,5,4,-2,-1,-1, 16 };

    public static void main(String[] args) {

        int sum = -1;

        boolean isSubArrayExists = checkSubArrayForGivenSum(ARR, sum);
        System.out.println(isSubArrayExists);
    }

    public static boolean checkSubArrayForGivenSum(int[] arr, int sum) {

        Set<Integer> s = new HashSet<>();
        int pre_sum = 0;

        for(int i : arr) {
            pre_sum += i;

            if(s.contains(pre_sum - sum) || pre_sum == sum || i == sum) {
                return true;
            }
            s.add(pre_sum);
        }

        return false;
    }
}
