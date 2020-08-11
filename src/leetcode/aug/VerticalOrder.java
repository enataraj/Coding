package leetcode.aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tree.util.TreeNode;

public class VerticalOrder {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        Map<TreeNode, Integer> posMap = new HashMap();
        int pos = 0;
        int minPos = 0;
        int maxPos = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        posMap.put(root, pos);
        Map<Integer, List<Integer>> ansMap = new HashMap();
        while(queue.peek() != null){
            int size = queue.size();
            for (int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                pos = posMap.get(node);
                List nodeList = null;
                if (ansMap.containsKey(pos))
                    nodeList = ansMap.get(pos);
                else 
                    nodeList = new ArrayList();
                nodeList.add(node.val);
                ansMap.put(pos, nodeList);
                if (pos < minPos) minPos = pos;
                if (pos > maxPos) maxPos = pos;
                if (node.left != null){
                     queue.offer(node.left); 
                     posMap.put(node.left , pos-1);
                }
                if (node.right != null){
                     queue.offer(node.right); 
                     posMap.put(node.right, pos+1 );
                }
            }
        }
        List<List<Integer>>ansList = new ArrayList();
        for (int i = minPos ; i <= maxPos; i++){
            if (ansMap.containsKey(i))
                ansList.add(ansMap.get(i));
        }
        //System.out.println(ansList);
        return ansList;
    }
    
}

