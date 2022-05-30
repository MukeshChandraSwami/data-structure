package recursion.v3;

public class StrToInt {

    public static void main(String[] args) {
        String s = "12345";
        int i = parseStringToInt1(s);
        System.out.println(i);
    }

    private static int parseStringToInt1(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        return parseStringToInt1(s.substring(0,s.length() - 1)) * 10 + Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
    }
}
