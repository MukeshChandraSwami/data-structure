package hashing.easy;

import java.util.*;
import java.util.stream.Collectors;

public class GroupWordOfSameSetOfCharacters {

    public static void main(String[] args) {

        String words[] = { "may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};

        Map<String, List<String>> group = getGroupOfWords(words);
        System.out.println(group);
    }

    private static Map<String, List<String>> getGroupOfWords(String[] words) {
        Map<String, List<String>> group = new HashMap<>();

        for(String s : words) {
            String key = getKey(s);

            if(group.containsKey(key)) {
                group.get(key).add(s);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(s);
                group.put(key, ls);
            }
        }

        return group;
    }

    private static String getKey(String s) {
        Set<String> set = new TreeSet<>();
        for(int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }
        return String.join("", set);
    }
}
