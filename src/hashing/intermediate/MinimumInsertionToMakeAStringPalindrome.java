package hashing.intermediate;

import java.util.HashMap;
import java.util.Map;

public class MinimumInsertionToMakeAStringPalindrome {

    public static void main(String[] args) {

        String str = "GEEKS";

        int count = getCountOfMinChar(str);
        System.out.println(count);
    }

    private static int getCountOfMinChar(String str) {
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean one = true;

        for(Character ch : map.keySet()) {
            if(map.get(ch) == 1 && one) {
                one = false;
                continue;
            }

            count = map.get(ch) % 2 == 0 ? count : count + 1;
        }

        return one && count == 1 ? 0 : count;
    }
}
