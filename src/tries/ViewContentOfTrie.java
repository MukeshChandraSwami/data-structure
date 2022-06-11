package tries;

import tries.common.Trie;

public class ViewContentOfTrie {

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

        trie.print();
    }
}
