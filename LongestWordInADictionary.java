// Time Complexity : O(N * L) , N = number of words and L = average length of the word
// Space Complexity :  O(N * L) , N = number of words and L = average length of the word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Maintain a trie data structure to store the input words and have a word field to identify the current node's
word.Now, call dfs method on root. We recursively traverse through the children of the root making sure child
is not null and its corresponding word not null.Now, compare the result length with the incoming child node's
word length and update if we find the longest word. For words with equal length, its automatically handled as
dfs traverses alphabetically and we only update when longer word is found.
 */
class Solution {
    TrieNode root;
    String result = "";

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for(String word : words) {
            insert(word);
        }

        dfs(root);
        return result;
    }

    private void dfs(TrieNode node) {
        if(node == null)
            return;

        if(node.word != null) {
            if(node.word.length() > result.length())
                result = node.word;
        }

        for(TrieNode child : node.children) {
            if(child != null && child.word != null)
                dfs(child);
        }
    }
}