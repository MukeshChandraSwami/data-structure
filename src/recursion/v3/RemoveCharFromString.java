package recursion.v3;

public class RemoveCharFromString {

    public static void main(String[] args) {
        String s = "Geeks For Geeks";
        System.out.println("String :- " + s);
        char ch = 'e';
        String updatedString = removeCharacter3(new StringBuffer(s), ch, 0);
        System.out.println("Updated String:- " + updatedString);
    }

    private static String removeCharacter1(String str, char ch, int index) {
        if(str.length() == index) {
            return "";
        }
        char c = str.charAt(index);
        String s = c == ch ? "" : String.valueOf(c);
        
        return s + removeCharacter1(str,ch, index + 1);
    }

    private static String removeCharacter2(char[] arr, char ch, int index) {
        if(arr.length == index) {
            return new String(arr).trim();
        }
        if(arr[index] == ch) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = Character.MIN_VALUE;
        } else {
            index += 1;
        }
        return removeCharacter2(arr,ch, index);
    }

    private static String removeCharacter3(StringBuffer s, char ch, int index) {
        if(s.length() == index) {
            return new String(s);
        }

        if(s.charAt(index) == ch)
            s.deleteCharAt(index);
        else
            index += 1;

        return removeCharacter3(s,ch, index);
    }
}
