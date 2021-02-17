package leetcode.feb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }

        }

        return result;

    }
    
 public List<Integer> rightSideViewBFS(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        if(root== null)
            return list;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);        
      
        while(!queue.isEmpty())
        {
              int levelSize = queue.size();
            
            for(int i=0;i<levelSize;i++)
            {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(i == levelSize-1)
                    list.add(node.val);
            }
         }     
        
        return list;      
        
    }  

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideViewDFS1(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level)
            result.add(root.val);
        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }

    public static void main(String[] args) {
        LC199BinaryTreeRightSideView obj = new LC199BinaryTreeRightSideView();
        TreeNode root = TreeUtil.constructBalancedBinaryTreeRightSideView1();
        System.out.println(obj.rightSideView(root));

    }

}
