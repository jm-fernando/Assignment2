import java.util.*;
import java.lang.*;

public class Spelling implements Dictionary {
	
	private static TrieNode root;
	public int size;
	
	public Spelling() {
		root = new TrieNode();
		size = 0;
	}
	
	private class TrieNode {
		
		private final int SIZE = 127; //max ASCII characters
		private TrieNode[] letters;
		private boolean end;
		
		public TrieNode() {
			letters = new TrieNode[SIZE];
			end = false;
		}
	}
	
	public void insert(String s) {
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			int current = s.charAt(i);
			if(node.letters[current] == null) {
				node.letters[current] = new TrieNode();
			}
			node = node.letters[current];
		}
		node.end = true;
		++size;
	}
	
	public static boolean find(String s) {
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			int current = s.charAt(i);
			if(node.letters[current] == null) {
				return false;
			}
			node = node.letters[current];
		}
		return node.end;
	}
}