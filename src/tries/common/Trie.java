package tries.common;

import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public Trie(int size) {
        this.root = new TrieNode(size);
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public void insert(String value) {
        insertAndSpecifyNewItem(value);
    }

    public boolean insertAndSpecifyNewItem(String value) {
        TrieNode t = this.root;
        boolean isNew = false;

        for (char ch : value.toCharArray()) {
            int index = DSUtils.getIndexForTrie(ch, 26);
            if (Objects.isNull(t.get(index))) {
                t.set(index, new TrieNode());
                isNew = true;
            }
            t = t.get(index);
        }
        t.setEnd(true);
        return isNew;
    }

    public boolean search(String str) {

        return searchInternal(str).map(TrieNode::isEnd).orElse(false);
    }

    public boolean delete(String key) {

        this.delete(this.root, key, 0);
        return !this.search(key);
    }

    public boolean isEmpty() {
        return this.isEmpty(this.root);
    }

    public void print() {
        List<String> l = new ArrayList<>();

        dictionaryOrder(this.root, "",  l);

        System.out.println(l);
    }

    public void dictionaryOrder(TrieNode node, String content, List<String> l) {
        if(Objects.isNull(node))
            return;

        for(int i = 0; i < node.getSize(); i++) {
            TrieNode child = node.get(i);
            if(Objects.nonNull(child)) {
                String res = content + (char) ('a' + i);
                if (child.isEnd())
                    l.add(res);
                dictionaryOrder(child, res, l);
            }
        }
    }

    private Optional<TrieNode> searchInternal(String str) {
        TrieNode t = this.root;

        for (char ch : str.toCharArray()) {
            int index = DSUtils.getIndexForTrie(ch, 26);
            if (Objects.isNull(t.get(index))) {
                return Optional.empty();
            }
            t = t.get(index);
        }
        return Optional.of(t);
    }

    private boolean isEmpty(TrieNode t) {
        if (Objects.isNull(t)) return true;

        boolean empty = true;

        for (int i = 0, j = this.root.getChildren().length - 1; i <= j; i++, j--) {

            if (Objects.nonNull(t.get(i)) || Objects.nonNull(t.get(j))) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    private TrieNode delete(TrieNode node, String key, int depth) {
        if (Objects.isNull(node)) {
            return null;
        }

        if (depth == key.length()) {

            // Marking the node as end.
            node.setEnd(false);

            // If it is the last node then we can delete it
            if (isEmpty(node)) {
                node = null;
            }
            return node;
        }

        int index = DSUtils.getIndexForTrie(key.charAt(depth), 26);

        node.set(index, delete(node.get(index), key, depth + 1));

        if (!node.isEnd() && isEmpty(node)) {
            node = null;
        }

        return node;
    }
}
