package recursion.v3;

public class RemoveConsecutiveChar {

    public static void main(String[] args) {
        String s = "abcdeee";
        System.out.println("String:- " + s);
        String updatedString = removeConsecutiveCharacters3(new StringBuffer(s), 0);
        System.out.println("Updated String:- " + updatedString);
    }

    private static String removeConsecutiveCharacters1(String s, int index) {
        if(s.length() == index)
            return "";

        char ch = s.charAt(index);
        String updatedString = removeConsecutiveCharacters1(s, index + 1);

        return updatedString.startsWith(String.valueOf(ch)) ? updatedString : ch + updatedString;
    }

    private static String removeConsecutiveCharacters2(char[] arr, int index) {
        if(arr.length - 1 == index) {
            return new String(arr).trim();
        }

        if(arr[index] != Character.MIN_VALUE && arr[index] == arr[index + 1]) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = Character.MIN_VALUE;
        } else {
            index += 1;
        }
        return removeConsecutiveCharacters2(arr, index);
    }

    private static String removeConsecutiveCharacters3(StringBuffer s, int index) {
        if(s.length() - 1 == index) {
            return new String(s);
        }

        if(s.charAt(index) == s.charAt(index + 1)) {
            s.deleteCharAt(index);
        } else {
            index += 1;
        }
        return removeConsecutiveCharacters3(s, index);
    }
}
