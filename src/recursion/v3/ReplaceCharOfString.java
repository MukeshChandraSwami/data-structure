package recursion.v3;

public class ReplaceCharOfString {

    public static void main(String[] args) {

        String s = "My name is Mukesh and i am a software developer.";
        System.out.println("String:- " + s);
        char chToReplace = ' ';
        String updatedString = replaceCharacter2(s.toCharArray(), chToReplace, 0);
        System.out.println("Updated String:- " + updatedString);
    }

    private static String replaceCharacter1(char[] chArr, char chToReplace, int index) {
        if(chArr.length == index) {
            return new String(chArr);
        }
        chArr[index] = chArr[index] == chToReplace ? 'X' : chArr[index];

        return replaceCharacter1(chArr, chToReplace, index + 1);
    }

    private static String replaceCharacter2(char[] chArr, char chToReplace, int index) {
        if(chArr.length == index) {
            return "";
        }
        char c = chArr[index] == chToReplace ? 'X' : chArr[index];

        return c + replaceCharacter2(chArr, chToReplace, index + 1);
    }
}
