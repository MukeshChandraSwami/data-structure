package searching;

public class JumpSearch {

    public static void main(String[] args) {
        int arr[] = {0,  1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int element = -10;
        int jump = 3;

        boolean isAvailable = search(arr, element, jump);
        //boolean isAvailable = searchRecursion(arr, element, 0, arr.length - 1);
        System.out.println("Is available : " + isAvailable);
    }

    private static boolean search(int[] arr, int element, int jump) {

        for(int i = 0; i < arr.length + jump; i = i+jump ) {
            int temp = i > arr.length - 1 ? arr.length - 1 : i;
            if(arr[temp] >= element) {
                for(int j = temp; j > temp - jump; j--) {
                    if(arr[j] == element)
                        return true;
                    else
                        return false;
                }
            }
        }
        return false;
    }
}
