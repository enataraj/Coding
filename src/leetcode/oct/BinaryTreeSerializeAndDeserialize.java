package leetcode.oct;

import java.util.Arrays;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class BinaryTreeSerializeAndDeserialize {

    StringBuffer result = new StringBuffer();

    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfsHelper(root);
        return result.deleteCharAt(result.length()-1).toString();
    }

    private void dfsHelper(TreeNode node) {
        if (node == null) {

            result.append('N');
            result.append(',');
            return;
        }
        result.append(node.val);
        result.append(',');
        dfsHelper(node.left);
        dfsHelper(node.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] dataStr = data.split(",");
       // System.out.println(Arrays.toString(dataStr) + " Len :" + dataStr.length);
        TreeNode root = dfsHelperDeserialize(dataStr);
        return root;
    }

    private TreeNode dfsHelperDeserialize(String[] arr) {

        if (index == arr.length || arr[index].equals("N")) {
            ++index;
            return null;
        }

        int rootVal = Integer.parseInt(arr[index]);
        ++index;

        TreeNode root = new TreeNode(rootVal);
        root.left = dfsHelperDeserialize(arr);
        root.right = dfsHelperDeserialize(arr);

        return root;

    }
    
    
    // Encodes a tree to a single string.
    public String serializeBST(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        
        return sb.toString(); 
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
         if(root==null)
            return;
        sb.append(root.val).append(',');   
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);  
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserializeBST(String data) {
        if(data==null || data.isEmpty())
            return null;
        String[] arr = data.split(",");
        int[] nums = new int[arr.length];
        int i=0;
        for(String s: arr)
            nums[i++] = Integer.valueOf(s);
        
        return deserializeHelper(nums, new int[]{0},
                                 Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserializeHelper(int[] nums, int[] index, int lo, int hi) {
       int currIndex = index[0];
        if(currIndex >= nums.length)
            return null;
         
        if(nums[currIndex] > hi || nums[currIndex] < lo) {
            --index[0];
            return null;
        }
       
        TreeNode root = new TreeNode(nums[currIndex]);
        
        index[0]++;
        root.left = deserializeHelper(nums, index, lo, nums[currIndex]);
        
        index[0]++;
        root.right = deserializeHelper(nums, index, nums[currIndex], hi);
        return root;
        
    }

    public static void main(String[] args) {

        BinaryTreeSerializeAndDeserialize obj = new BinaryTreeSerializeAndDeserialize();
        TreeNode root = TreeUtil.constructBinaryTree();
        TreeUtil.preOrderTraversal(root);
        System.out.println();
        String result = obj.serialize(root);
        System.out.println(result);
        root = obj.deserialize(result);
        TreeUtil.preOrderTraversal(root);

    }

}
