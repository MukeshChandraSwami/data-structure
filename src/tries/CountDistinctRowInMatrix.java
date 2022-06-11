package tries;

import tries.common.Trie;

public class CountDistinctRowInMatrix {

    private static char MATRIX[][] = {
            {'1', '0', '0'},
            {'1', '1', '1'},
            {'1', '0', '0'},
            {'0', '1', '0'}
    };


    public static void main(String[] args) {

        Trie trie = new Trie(2);
        int distinctRow = 0;
        for(int i = 0; i < 4; i++) {
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < 3; j++) {
                s.append(MATRIX[i][j]);
            }
            distinctRow = trie.insertAndSpecifyNewItem(s.toString()) ? distinctRow + 1 : distinctRow;
        }

        System.out.println("Distinct rows are:- " + distinctRow);
    }
}
