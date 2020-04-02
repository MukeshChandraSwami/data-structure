package searching;

public class LinearSearch {

    public static void main(String[] args) {

        int arr[] = {10,20,30,40,50,60};
        int element = 600;

        //boolean isAvailable = search(arr, element);
        boolean isAvailable = searchRecursion(arr,element,0);
        System.out.println("Is available : " + isAvailable);
    }

    private static boolean search(int[] arr, int element) {

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    private static boolean searchRecursion(int[] arr, int element, int index) {

        if(index < arr.length) {
            if(arr[index] == element) {
                return true;
            } else {
                return searchRecursion(arr,element,index+1);
            }
        }
        return false;
    }
}
