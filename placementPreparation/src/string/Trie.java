package string;
/**
 * @Trie_Create_Insert_WordSearch_PrefixSearch
 */
//creation of trie [Create Trie, Insert, Word Search, Prefix search]
public class Trie {
	class Node{
		Node[] child;
		boolean isEnd;
		Node(){
			child = new Node[26];
			isEnd = false;
		}
	}
	
	Node root;
	void trie() {
		root = new Node();
	}
	
	void insert(String word) {
		Node curr = root;
		for(char ch: word.toCharArray()) {
			if(curr.child[ch-'a'] == null) {
				curr.child[ch-'a'] = new Node();
			}
		}
		curr.isEnd = true;
	}
	
	boolean searchWord(String word) {
		Node curr = root;
		for(char ch: word.toCharArray()) {
			if(curr.child[ch-'a'] == null) {
				return false;
			}
			curr = curr.child[ch-'a'];
		}
		return curr.isEnd;
	}
	
	boolean searchPrefix(String prefix) {
		Node curr = root;
		for(char ch: prefix.toCharArray()) {
			if(curr.child[ch-'a'] == null) {
				return false;
			}
			curr = curr.child[ch-'a'];
		}
		return true;
	}
}
