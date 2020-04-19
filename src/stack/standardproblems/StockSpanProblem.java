package stack.standardproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * This class is responsible to solve Stock Span Problem.
 */

/*
* What is stack span problem ?
* It is a solution to find span in stock. For ex :
* We have stock price of 7 days : (100(1), 80(2), 60(3), 70(4), 60(5), 75(6), 85(7))
* Now i need to check span for day 6.
* Then i track it in back side for consecutive days who less price then day 6 -> 5,4,3 and itself
* So total span for day 6 is 4.
*
* Conditions : 1. price_of_ith_day > price_of_days_less_then_i
*              2. Days should be consecutive.
* */
public class StockSpanProblem {

    public static void main(String[] args) {

        List<Integer> stockPrice = Arrays.asList(100, 80, 60, 70, 60, 75, 85);

        List<Integer> span = stockSpanProblem2(stockPrice);

        System.out.print("Stock Price : " + stockPrice);
        System.out.print("\n\nSpan : " + span);
    }

    /**
     * @param stockPrice
     * @return
     *
     * Algo :
     * Step 1 : Traverse stock price.
     * Step 2 : Traverse in back side until days contain lesser price of current day.
     * Step 3 : Calculate span and add in array or list.
     * Step 4 : Return result.
     */
    public static List<Integer> stockSpanProblem1(List<Integer> stockPrice) {

        List<Integer> span = new ArrayList<>();

        for(int i = 0; i < stockPrice.size(); i++) {
            int spanCounter = 1;
            int price = stockPrice.get(i);
            for(int j = i - 1; j >= 0 && price > stockPrice.get(j); j--) {
                spanCounter++;
            }
            span.add(spanCounter);
        }

        return span;
    }

    /**
     * @param stockPrice
     * @return
     *
     * Algo :
     * We will have 3 components :
     * 1. Stock Price List or Array.
     * 2. Span List or Array
     * 3. Stack of days.
     *
     * Step 1 : stack.push(0); and span[0] = 1; Because span will always be 1 for day 0.
     * Step 2 : FOR i =1 to N  {
     * Step 3 : WHILE !stack.isEmpty() AND stockPrice[stack.top] <= stockPrice[i]
     *              stack.pop();
     * Step 4 : IF stack.isEmpty()
     *              span[i] = i + 1;
     *          ELSE
     *              span[i] = i - stack.peek();
     * Step 5 : stack.push(i);
     */
    public static List<Integer> stockSpanProblem2(List<Integer> stockPrice) {

        Integer []span = new Integer[stockPrice.size()];
        Stack<Integer> days = new Stack<>();

        span[0] = 1;                        // Step 1
        days.push(0);

        for(int i = 1; i < stockPrice.size(); i++) {        // Step 2

            while(!days.isEmpty() && stockPrice.get(days.peek()) <= stockPrice.get(i))          // Step 3
                days.pop();

            if(days.isEmpty())                  // Step 4
                span[i] =  i+1;
            else
                span[i] = i - days.peek();

            days.push(i);                       // Step 5
        }
        return Arrays.asList(span);
    }
}
