package tree.avl.srarch.and.print;

public class NumberOfNodesAtGivenHeight {

    public static void main(String[] args) {

        int height = 3;
        int nodes = getPossibleNumberOfNodesAtGivenHeight(height);
        System.out.println(nodes);
    }

    public static int getPossibleNumberOfNodesAtGivenHeight(int height) {
        if(height == 0)
            return 1;
        if(height == 1)
            return 2;

        return (1
                + getPossibleNumberOfNodesAtGivenHeight(height - 1)
                + getPossibleNumberOfNodesAtGivenHeight(height - 2));
    }
}
