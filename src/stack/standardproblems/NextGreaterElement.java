package stack.standardproblems;

import java.util.Arrays;
import java.util.Stack;

/**
 * This class is responsible to find out next greater element of current element. For ex :
 * Input list : 5,3,2,10,6,8,1,4,12,7,4
 * Result :
 * 5    ->  10
 * 3    ->  10
 * 2    ->  10
 * 10   ->  12
 * 6    ->  8
 * 8    ->  12
 * 1    ->  4
 * 4    ->  12
 * 12   ->  No
 * 7    ->  No
 * 4    ->  No
 *
 * Algo :
 *
 * Step 1 : FOR i = 0 to N
 * Step 2 : check if stack.isEmpty() || stack.peek() >= arr[i] then push arr[i]
 * Step 3 : Otherwise current element is next greater element, pop it until stack.peek() <= arr[i]
 * Step 4 : push arr[i] in stack
 * Step 5 : If stack is still not empty then pop all elements with no next greater element tag.
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {5,3,2,10,6,8,1,4,12,7,4};
        findNextGreaterElement(arr);
    }

    public static void findNextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < arr.length; i++) {                                    // Step 1

            if(stack.isEmpty() || stack.peek() >= arr[i]) {                     // Step 2
                stack.push(arr[i]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {                // Step 3
                System.out.print("\n" + stack.pop() + " -> " + arr[i]);
            }
            stack.push(arr[i]);                                                 // Step 4
        }

        while (!stack.isEmpty()) {                                              // Step 5
            System.out.print("\n" + stack.pop() + " -> No");
        }
    }
}
