package stack.standardproblems;


import java.util.Stack;

/**
 * This class will solve tower of hanoi problem via stack. Algo :
 * Step 1 : Create 3 stacks      ->  source,destination and aux
 * Step 2 : Push N disks in decreasing order in source stack.
 * Step 3 : toh(int n, source, aux, dest)
 *      3.1 : if(n >= 1)
 *      3.2 : toh(n-1, source,dest,aux)
 *      3.3 : dest.push(source.pop());
 *      3.4 : toh(n-1, aux,source,dest)
 * Step 4 : Print stack destination.
 */
public class TowerOfHanoi {

    public static void main(String[] args) {

        int n = 20;
        Stack<Integer> source = new Stack();
        Stack<Integer> aux = new Stack();
        Stack<Integer> dest = new Stack();

        for(int i = n; i > 0; i--)
            source.push(i);

        System.out.print("Source : " + source);

        toh(n,source,aux,dest);

        System.out.print("\n\nDestination : " + dest);
    }

    /**
     * @param n
     * @param source
     * @param aux
     * @param dest
     *
     * Just to remember :
     * Source       ->  S
     * Aux          ->  A
     * Destination  ->  D
     *
     * S + A + D => SAD     ->  Order of stacks
     */
    public static void toh(int n, Stack<Integer> source, Stack<Integer> aux, Stack<Integer> dest) {

        if(n >= 1) {
            toh(n-1,source,dest,aux);
            Integer num = source.pop();
            dest.push(num);
            toh(n-1, aux,source,dest);
        }
    }
}
