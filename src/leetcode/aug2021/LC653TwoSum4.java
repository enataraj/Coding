package leetcode.aug2021;

import java.util.HashSet;
import java.util.Set;

import tree.util.TreeNode;

public class LC653TwoSum4 {

    boolean result = false;
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        dfsHelper(root,k,set);
        return result;
        
    }
    
    private void dfsHelper(TreeNode node,int target,Set<Integer> set){
        if(node==null){
            return;
        }
        if(set.contains(target-node.val)){
            result = true;
            return;
        }
        set.add(node.val);
        dfsHelper(node.left,target,set);
        dfsHelper(node.right,target,set);
    }
    
}
