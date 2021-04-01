package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import tree.util.TreeNode;

public class LC501ModeInBinaryTree {
    Map<Integer, Integer> freqMap = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }

        dfsHelpher(root);
        List<Integer> tmpList = new ArrayList<>();
        int count = Integer.MIN_VALUE;
        for (int key : freqMap.keySet()) {
            if (count == freqMap.get(key)) {
                tmpList.add(key);
            } else if (count < freqMap.get(key)) {
                count = freqMap.get(key);
                tmpList = new ArrayList<Integer>();
                tmpList.add(key);
            }
        }

        int[] result = new int[tmpList.size()];
        int i = 0;
        for (int num : tmpList) {
            result[i] = num;
            i++;
        }
        return result;
    }

    private void dfsHelpher(TreeNode node) {
        if (node == null) {
            return;
        }

        dfsHelpher(node.left);

        if (freqMap.containsKey(node.val)) {
            freqMap.put(node.val, freqMap.get(node.val) + 1);
        } else {
            freqMap.put(node.val, 1);
        }
        dfsHelpher(node.right);

    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;
    TreeNode prev = null;
    int count = 0;

    public int[] findModeSol(TreeNode root) {

        List<Integer> modes = new ArrayList<>();

        inorder(modes, root);

        int[] arr = new int[modes.size()];

        for (int i = 0; i < modes.size(); i++) {
            arr[i] = modes.get(i);
        }

        return arr;

    }

    public void inorder(List<Integer> modes, TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(modes, root.left);
        if (prev != null) {
            if (prev.val == root.val) {
                count++;
            } else {
                count = 0;
            }

        }
        if (count > max) {
            max = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == max) {
            modes.add(root.val);
        }

        prev = root;
        inorder(modes, root.right);

    }
    
    
    public int[] findModeSol2(TreeNode root) {
        inorder(root, true);
        num = Integer.MIN_VALUE;
        curr = 0;
        inorder(root, false);
        
        int[] ans = new int[list.size()];
        int i = 0;
        for (int n : list) ans[i++] = n;
        return ans;
    }
    
    private int max1 = 0, curr = 0, num = Integer.MIN_VALUE;
    private List<Integer> list = new LinkedList<>();
    
    private void inorder(TreeNode node, boolean search) {
        if (node == null) return;
        
        inorder(node.left, search);
        
        if (num == node.val) {
            curr += 1;
        } else {
            curr = 1;
            num = node.val;
        }
        
        if (search) max = Math.max(max, curr);
        else if (curr == max) list.add(num);
        
        inorder(node.right, search);
    }

    public static void main(String[] args) {
        LC501ModeInBinaryTree obj = new LC501ModeInBinaryTree();
    }

}
