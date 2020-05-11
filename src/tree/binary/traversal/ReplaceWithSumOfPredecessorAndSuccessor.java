package tree.binary.traversal;

import utils.DSUtils;

public class ReplaceWithSumOfPredecessorAndSuccessor {

    public static void main(String[] args) {

        int result[] = getSumOfPredecessorAndSuccessor(DSUtils.IN_ORDER);
        System.out.print("In order traversal : ");
        for(int i = 0; i <  DSUtils.IN_ORDER.length; i++){
            System.out.print("\t" + DSUtils.IN_ORDER[i] + "\t|");
        }

        System.out.print("\n\nIn order traversal of sum: ");
        for(int i = 0; i <  result.length; i++){
            System.out.print("\t" + result[i] + "\t|");
        }
    }

    private static int[] getSumOfPredecessorAndSuccessor(int[] inOrder) {

        int arr[] = new int[inOrder.length];

        for(int i = 0; i < arr.length;i++) {

            int predecessor = i-1 < 0 ? 0 : inOrder[i-1];
            int successor = i+1 > arr.length - 1 ? 0 : inOrder[i+1];
            arr[i] = predecessor + successor;
        }

        return arr;
    }
}
