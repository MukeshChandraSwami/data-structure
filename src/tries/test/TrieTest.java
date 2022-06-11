package tries.test;

import tries.common.Trie;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("mukesh swami");
        trie.insert("sonam");
        trie.insert("an");
        trie.insert("and");

        System.out.println(trie.search("mukesh swami"));
        System.out.println(trie.search("sonam"));
        System.out.println(trie.search("an"));
        System.out.println(trie.search("and"));

        boolean deleted = trie.delete("an");
        System.out.println(deleted);

        System.out.println(trie.search("mukesh swami"));
        System.out.println(trie.search("sonam"));
        System.out.println(trie.search("an"));
        System.out.println(trie.search("and"));
    }
}
