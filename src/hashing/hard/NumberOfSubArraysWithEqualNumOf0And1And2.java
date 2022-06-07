package hashing.hard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithEqualNumOf0And1And2 {

    public static void main(String[] args) {
        String str = "0102010";

        int count = getCount(str);
        System.out.println(count);
    }

    private static int getCount(String str) {

        int z = 0;
        int o = 0;
        int t = 0;
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0-0", 1);

        for(int i = 0; i < str.length(); i++) {
            int v = Integer.parseInt(String.valueOf(str.charAt(i)));

            z = v == 0 ? z + 1 : z;
            o = v == 1 ? o + 1 : o;
            t = v == 2 ? t + 1 : t;

            String key = (z - o) + "-" + (z-t);
            count += map.getOrDefault(key, 0);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}
