package stack.standardproblems;

import stack.Stack;

/**
 * This class is responsible to check whether any celebrity is present in party or not. If yes then who is that celebrity.
 * There are 2 characteristics of celebrity :
 * 1. All the persons in party should know that celebrity.
 * 2. Celebrity should not know anyone in the party
 *
 * Algo :
 *
 * Step 1 : push all the peoples in stack.
 * Step 2 : Pop 2 peoples from stack and check if A knows to B.
 *      2.1 : If yes then A can not be a celebrity and push B back to stack.
 *      2.2 : If no then A can be a celebrity so push A back to stack.
 * Step 3 : Do it until only 1 person left in the stack.
 * Step 4 : Finally check whether this person knows anyone in the party
 *      4.1 : If yes then it can not be a celebrity
 *      4.2 : Else it is the celebrity.
 */
public class CelebrityProblem {

    static int MATRIX[][] = { { 0, 0, 1, 0 },
                              { 0, 0, 1, 0 },
                              { 0, 0, 0, 0 },
                              { 0, 0, 1, 0 } };

    public static void main(String[] args) {

        int total = 4;
        int celebrity = checkForCelebrity(total);
        if(celebrity == -1) {
            System.out.print("No Celebrity");
        } else {
            System.out.print("Celebrity : " + (celebrity + 1));
        }
    }

    private static int checkForCelebrity(int total) {

        Stack stack = new Stack(total);

        for(int i = 0; i < total; i++)
            stack.push(i);

        while(stack.size() > 1) {

            int a = stack.pop();
            int b = stack.pop();
            if(MATRIX[a][b] == 0) {
                stack.push(a);
            } else {
                stack.push(b);
            }
        }

        int celebrity = stack.pop();
        for(int i = 0; i < total; i++) {
            if((MATRIX[celebrity][i] == 1 || MATRIX[i][celebrity] == 0) && i != celebrity) {
                celebrity = -1;
                break;
            }
        }

        return celebrity;
    }
}
