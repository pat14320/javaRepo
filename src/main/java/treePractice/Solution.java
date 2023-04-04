package treePractice;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	
	public static TrieNode buildTree(String[] words) {
		TrieNode root = new TrieNode();
		
		// Populate all links of words and also the last node that stores the word itself
		for (String word : words) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (curr.next[c - 'a'] == null) {
					curr.next[c - 'a'] = new TrieNode();
				}
				curr = curr.next[c - 'a'];
			}
			curr.word = word;
		}
		
		return root;
	}
	
	public static void dfs(char[][] board, int row, int col, TrieNode root, List<String> answer) {
		// Bounds check
		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length) {
			return;
		}
		
		// Check to see that current cell is not already visited
		if (board[row][col] == ' ') {
			return;
		}
		
		// Now, examining the current character
		char c = board[row][col];
		if (root.next[c - 'a'] == null) {
			return; // No more words based on this letter, return
		}
		
		// Otherwise, "use" the current character and check to see if we're at an answer
		root = root.next[c - 'a'];
		
		if (root.word != null) {
			answer.add(root.word);
			root.word = null; // Removing to avoid duplicate findings of the same word
		}
		
		// Now, keep iterating in all four directions
		board[row][col] = ' '; // Mark current cell as visited
		
		dfs(board, row + 1, col, root, answer);
		dfs(board, row - 1, col, root, answer);
		dfs(board, row, col + 1, root, answer);
		dfs(board, row, col - 1, root, answer);
		
		// Done visiting this node, put it back now
		board[row][col] = c;
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> answer = new ArrayList<String>();
		// input validation
		if (board == null || words == null || board.length == 0 || words.length == 0) {
			return answer;
		}
		TrieNode root = buildTree(words);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				dfs(board, i, j, root, answer);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'o','a','a','n'}, 
			{'e','t','a','e'}, 
			{'i','h','k','r'}, 
			{'i','f','l','v'}
		};
		String[] words = new String[] {"oath","pea","eat","rain"};
		
		System.out.println(findWords(board, words).toString());
	}

}
