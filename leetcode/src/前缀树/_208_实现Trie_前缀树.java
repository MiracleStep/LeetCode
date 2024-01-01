package 前缀树;

public class _208_实现Trie_前缀树 {
    class Trie {
        class TrieNode {
            boolean end;
            TrieNode[] nodes = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (p.nodes[u] == null) p.nodes[u] = new TrieNode();
                p = p.nodes[u];
            }
            p.end = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (p.nodes[u] == null) return false;
                p = p.nodes[u];
            }
            return p.end;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int u = prefix.charAt(i) - 'a';
                if (p.nodes[u] == null) return false;
                p = p.nodes[u];
            }
            return true;
        }
    }
}
