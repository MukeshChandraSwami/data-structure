package stack;

import java.util.Arrays;

public class SortArrayUsingStack {

    public static void main(String[] args) {

        Integer arr[] = {2, 3, 1};
        System.out.print("Unsorted Array : ");
        Arrays.asList(arr)
                .stream()
                .forEach(data -> {
                    System.out.print("\t" + data + "\t|");
                });

        arr = sortArray(arr);

        System.out.print("\n\nSorted Array : ");
        Arrays.asList(arr)
                .stream()
                .forEach(data -> {
                    System.out.print("\t" + data + "\t|");
                });

    }

    private static Integer[] sortArray(Integer[] arr) {
        Stack stack = new Stack(arr.length);
        Arrays.stream(arr)
                .forEach(stack::push);
        Sort.sort(stack);

        for(int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
