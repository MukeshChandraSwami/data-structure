package stack.standardproblems;

import java.util.Stack;

public class NumberOfNGEs {

    public static void main(String[] args) {
        int []arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int query = 4;

        Stack<Integer> nges = getNGEs(arr,query);
        System.out.print("\n Total : " + nges.size());
        System.out.print("\n\n NGEs : " + nges);
    }

    private static Stack<Integer> getNGEs(int[] arr, int query) {

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            int element = query;
            if(!stack.isEmpty())
                element = stack.peek();

            if(arr[i] > element) {
                stack.push(arr[i]);
            }
        }

        return stack;
    }
}
