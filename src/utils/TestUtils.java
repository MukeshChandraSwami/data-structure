package utils;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {
    public static void main1() {

        List<Integer> list = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);

        int count = 0;
        while(list.size() != 1) {
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext()) {
                itr.next();
                ++count;
                if(count == 2) {
                    itr.remove();
                    count = 0;
                }
            }
            System.out.println(list);
        }
    }

    public static void main2() {

       String r =  reverse("Hello");
        System.out.println(r);
    }

    private static String reverse(String s) {
        if(s == null || s.isEmpty())
            return "";
        return s.substring(s.length()-1) + reverse(s.substring(0,s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(getKey("student"));
    }

    static final int MAX_CHAR = 26;

    // Generates a key from given string. The key
    // contains all unique characters of given string
    // in sorted order consisting of only distinct elements.
    static String getKey(String str)
    {
        boolean[] visited = new boolean[MAX_CHAR];
        Arrays.fill(visited, false);

        for (int j = 0; j < str.length(); j++) {
            int ch = str.charAt(j);
            int a = 'a';
            visited[ch - a] = true;
        }
        String key = "";
        for (int j=0; j < MAX_CHAR; j++)
            if (visited[j])
                key = key + (char)('a'+j);
        return key;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
