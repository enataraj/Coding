package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch2 {
    
   
        private class TrieNode {
            Map<Character, TrieNode> map;
            boolean isEnd;
            
            TrieNode() {
                map = new HashMap<>();
                isEnd = false;
            }
        }
        
        private class Trie {
            private TrieNode root;
            
            Trie() {
                root = new TrieNode();
            }
            
            void addWord(String word) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    cur.map.putIfAbsent(ch, new TrieNode());
                    cur = cur.map.get(ch);
                }
                
                cur.isEnd = true;
            }
            
            TrieNode getRoot() {
                return root;
            }
        }
        
        public List<String> findWords(char[][] board, String[] words) {
            if (words.length == 0 || board.length == 0 || board[0].length == 0) {
                return Collections.emptyList();
            }
            
            int rows = board.length,
                cols = board[0].length;
            
            Trie t = new Trie();
            
            for (String word : words) {
                t.addWord(word);
            }
            
            Set<String> set = new HashSet<>();
            int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dfs(board, t.getRoot(), i, j, dirs, "", set);
                }
            }
            
            return new ArrayList<>(set);
        }
        
        private void dfs(char[][] board, TrieNode cur, int i, int j, int[][] dirs, String partial, Set<String> res) {
            if (cur != null && cur.isEnd) {
                res.add(partial);
            } 
            
            if (!isValid(board, i, j) 
                || board[i][j] == '-'
                || cur == null
                || !cur.map.containsKey(board[i][j])) {
                return;
            }
            
            char temp = board[i][j];
            board[i][j] = '-';
            
            for (int[] dir : dirs) {
                int nextX = i + dir[0],
                    nextY = j + dir[1];
                dfs(board, cur.map.get(temp), nextX, nextY, dirs, partial + temp, res);
            }
            
            board[i][j] = temp;
        }
        
        private boolean isValid(char[][] board, int x, int y) {
            return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
        }
    

}
