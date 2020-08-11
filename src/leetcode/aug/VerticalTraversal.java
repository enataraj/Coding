package leetcode.aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.util.TreeNode;

public class VerticalTraversal {
    
 
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            
            int[] vals = new int[3];
            
            find(root, vals, 0, 0);
            
            int width = vals[1] - vals[0] + 1;
            
            int height = vals[2] + 1;
            
            ArrayList<Integer>[][] list = new ArrayList[width][height];
            
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    list[i][j] = new ArrayList<Integer>();
                }
            }
            
            helper(list, root, -vals[0], height - 1);
            
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            
            for(int i = 0; i < width; i++){
                ans.add(new ArrayList<Integer>());
                List<Integer> li = ans.get(i);
                for(int j = list[i].length-1; j >= 0; j--){
                    ArrayList<Integer> nums = list[i][j];
                    Collections.sort(nums);
                    li.addAll(nums);
                }
                
            }
            
            return ans;
        }
        
        private void helper(ArrayList<Integer>[][] list, TreeNode root, int x, int y){
            if(root == null)
                return;
            
            ArrayList<Integer> l = list[x][y];
            
            l.add(root.val);
            
            helper(list, root.left, x - 1, y - 1);
            
            helper(list, root.right, x + 1, y - 1);
        }
        
        private void find(TreeNode node, int[] vals, int w, int h){
            if(node == null)
                return;
            
            if(w < vals[0])
                vals[0] = w;
            
            if(w > vals[1])
                vals[1] = w;
            
            if(h > vals[2])
                vals[2] = h;
            
            find(node.left, vals, w - 1, h + 1);
            find(node.right, vals, w + 1, h + 1);
        }
    

}
