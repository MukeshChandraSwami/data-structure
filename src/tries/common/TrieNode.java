package tries.common;

public class TrieNode {

    private TrieNode [] children;
    private boolean isEnd;
    private int size;

    public TrieNode() {
        this(27);
    }

    public TrieNode(int size) {
        this.children = new TrieNode[size];
        this.isEnd = false;
        this.size = size;
    }

    public TrieNode get(int index) {
        return this.children[index];
    }

    public void set(int index, TrieNode node) {
        this.children[index] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public TrieNode setEnd(boolean end) {
        isEnd = end;
        return this;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public int getSize() {
        return this.size;
    }
}
