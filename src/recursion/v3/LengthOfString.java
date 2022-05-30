package recursion.v3;

import java.util.Objects;

public class LengthOfString {

    public static void main(String[] args) {

        String s = "Mukesh";
        int length = length(s);
        System.out.println(length);
    }

    private static int length(String s) {
        if(Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        return length(s.substring(1)) + 1;
    }
}
