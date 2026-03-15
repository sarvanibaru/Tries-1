// Time Complexity : O(M * L + N * L), M = number of words in dictionary, N = number of words in sentence,
//L = average length of the word
// Space Complexity : O(M * L + N * L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to maintain a trie for the words in the dictionary and split the sentence by space and compare each
word's substring or shortest string's presence(compare letter by letter) with that of dictionary's word in
the trie iteratively. If found,append it to the stringbuilder and return as string.If dictionary's word is
 longer, then we return the actual word(sentence) itself.
 */
class Solution {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

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
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word : dictionary) {
            insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for(int i = 0 ; i < splitArr.length ; i++) {
            if(i != 0)
                sb.append(" ");
            sb.append(getShortestWord(splitArr[i]));
        }
        return sb.toString();
    }

    private String getShortestWord(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null || curr.isEnd)
                break;
            sb.append(ch);
            curr = curr.children[ch - 'a'];
        }
        if(curr.isEnd)
            return sb.toString();
        return word;
    }
}