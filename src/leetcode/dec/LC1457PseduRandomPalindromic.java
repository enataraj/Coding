package leetcode.dec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC1457PseduRandomPalindromic {

    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null)
            return 0;
        dfsHelpher(root, new ArrayList<>());
        return result;
    }

    private void dfsHelpher(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);

        if (node.left == null && node.right == null) {
            System.out.println(list);
            Map<Integer, Integer> nodeMap = new HashMap<>();
            for (int num : list) {
                if (nodeMap.containsKey(num)) {
                    nodeMap.put(num, nodeMap.get(num) + 1);
                } else {
                    nodeMap.put(num, 1);
                }
            }
            int oddCount = 0;
            for (int val : nodeMap.values()) {
                if (val % 2 != 0) {
                    oddCount++;
                }
            }
            if (oddCount <= 1) {
                result += 1;
            }

            list.remove(list.size() - 1);

        } else {
            dfsHelpher(node.left, list);
            dfsHelpher(node.right, list);
            list.remove(list.size() - 1);
        }

    }
    
    
    
    private int ans;
    public int pseudoPalindromicPaths_Parin (TreeNode root) {
        ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        return ans;
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        } 
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null) {
            if (isPalindrome(map)) {
                ++ans;
            }
            
        } else {
            helper(root.left, map);
            helper(root.right, map);

        }
        
        if (map.put(root.val, map.get(root.val) - 1) == 1) {
            map.remove(root.val);
        }
    }
    
    private boolean isPalindrome(Map<Integer, Integer> map) {
        boolean isOddFound = false;
        for (int val : map.values()) {
            if ((val & 1) == 1) {
                if (isOddFound) {
                    return false;
                }
                isOddFound = true;
            }
        }
        return true;
    }

    
    int count = 0;
    
    public void preorder(TreeNode node, int path) {
        if (node != null) {
            // compute occurences of each digit 
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    public int pseudoPalindromicPaths_sol (TreeNode root) {
        preorder(root, 0);
        return count;
    }
    
    public static void main(String[] args) {
        LC1457PseduRandomPalindromic obj = new LC1457PseduRandomPalindromic();
        TreeNode root = TreeUtil.pesudoPalindromicTree();
        System.out.println(obj.pseudoPalindromicPaths(root));

    }

}
