package utils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {
    public static void main() {

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

    public static void main(String[] args) {

       String r =  reverse("Hello");
        System.out.println(r);
    }

    private static String reverse(String s) {
        if(s == null || s.isEmpty())
            return "";
        return s.substring(s.length()-1) + reverse(s.substring(0,s.length() - 1));
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
