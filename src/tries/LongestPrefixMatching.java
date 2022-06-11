package tries;

import tries.common.Trie;
import tries.common.TrieNode;
import utils.DSUtils;

import java.util.Objects;

public class LongestPrefixMatching {

    public static void main(String[] args) {
        Trie trie = new Trie(26);
        trie.insert("are");
        trie.insert("cater");
        trie.insert("base");

        System.out.print("Values of trie:- ");
        trie.print();

        String str = "basement";

        String longestPrefix = searchLongestPrefix(trie, str);
        System.out.println(longestPrefix);
    }

    private static String searchLongestPrefix(Trie trie, String input) {
        TrieNode root = trie.getRoot();
        StringBuilder temp = new StringBuilder();
        String res = "< Empty >";

        for(char ch : input.toCharArray()) {
            int index = DSUtils.getIndexForTrie(ch, -1);

            if(Objects.isNull(root))
                break;

            temp.append(ch);
            if(Objects.nonNull(root.get(index)) && root.get(index).isEnd()) {
                res = temp.toString();
            }
            root = root.get(index);
        }

        return res;
    }
}
