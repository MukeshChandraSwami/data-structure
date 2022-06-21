package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpiralMatrix {

    private static final int[][] MATRIX1 = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };

    private static final int[][] MATRIX2 = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
    };

    private static final int[][] MATRIX3 = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12},
            {13,14,15}
    };

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.stream(MATRIX3)
                .map(row -> IntStream.of(row).boxed().collect(Collectors.toList())).toList();

        List<Integer> ls = printSpiralOrder(list, 0, list.size() - 1, 0, list.get(0).size() - 1);
        System.out.println(ls);
    }

    private static List<Integer> printSpiralOrder(List<List<Integer>> matrix, int startRow, int endRow, int startCol, int endCol) {

        List<Integer> ls = new ArrayList<>();
        int size = matrix.size() * matrix.get(0).size();
        int count = 0;
        while(startRow <= endRow && startCol <= endCol) {

            for(int i = startCol; i <= endCol; i++) {
                ls.add(matrix.get(startRow).get(i));
                count++;
            }
            startRow += 1;

            if(count == size) return ls;

            for(int i = startRow; i <= endRow; i++) {
                ls.add(matrix.get(i).get(endCol));
                count++;
            }
            endCol -= 1;
            if(count == size) return ls;

            for(int i = endCol; i >= startCol; i--) {
                ls.add(matrix.get(endRow).get(i));
                count++;
            }
            endRow -= 1;
            if(count == size) return ls;

            for(int i = endRow; i >= startRow; i--) {
                ls.add(matrix.get(i).get(startCol));
                count++;
            }
            startCol += 1;
            if(count == size) return ls;
        }
        return ls;
    }
}
