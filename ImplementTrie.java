// Time Complexity : O(L)  where L is length of the word
// Space Complexity : O(n * L) , n = number of words, L = length of the word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Create a TrieNode class containing the children and a variable isEnd to identify the end of the word. For each
operation, we initialize the root to a current TrieNode and check if each letter in the input word is null or
not.For insert, if its null, we create new node, for search and prefix search, we return false as we did not find
that letter presence.We make sure to update the current pointer after each letter iteration to check for further
letters and after the loop stops, isEnd variable would confirm if we reached end of the word or not for search
except prefix search because it can have some other letters as well.
 */
class Trie {
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */