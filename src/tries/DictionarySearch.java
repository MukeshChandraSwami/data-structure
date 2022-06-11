package tries;

import tries.common.Trie;
import tries.common.TrieNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DictionarySearch {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("my");
        trie.insert("name");
        trie.insert("is");
        trie.insert("sidhu");
        trie.insert("mussewala");
        trie.insert("and");
        trie.insert("i");
        trie.insert("am");
        trie.insert("a");
        trie.insert("good");
        trie.insert("singer");
        trie.insert("sing");
        trie.insert("is");
        trie.insert("king");
        trie.insert("sintheta");

        String str = "a";
        List<String> ls = search(trie, str);
        System.out.println(ls);
    }

    private static List<String> search(Trie trie, String str) {
        TrieNode root = trie.getRoot();
        for(char ch : str.toCharArray()) {
            int index = DSUtils.getIndexForTrie(ch, -1);
            if(Objects.isNull(root.get(index))) {
                return null;
            }

            root = root.get(index);
        }

        List<String> ls = new ArrayList<>();
        if(root.isEnd())
            ls.add(str);

        trie.dictionaryOrder(root, str, ls);
        return ls;
    }
}
