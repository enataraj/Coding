package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC987VerticalOrderDFS {
    
    private class NodeData implements Comparable<NodeData> {
        int val;
        int height;

        public NodeData(int val, int height) {
            this.val = val;
            this.height = height;

        }

        @Override
        public String toString() {
            return "value : " + val + "height: " + height;
        }

        @Override
        public int compareTo(NodeData data) {

            if (this.height > data.height) {
                return 1;
            } 
            if(this.height == data.height) {
                if(this.val>= data.val) {
                    return 1;
                }
            }
            return -1;
        }
    }

   
    Map<Integer, List<NodeData>> verticalNodeMap = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;

        }

        dfsHelpher(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<NodeData> tmpList : verticalNodeMap.values()) {
            Collections.sort(tmpList);
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < tmpList.size(); i++) {
                resultList.add(tmpList.get(i).val);
            }
            result.add(resultList);
        }
        return result;
    }

    private void dfsHelpher(TreeNode node, int vertical, int height) {
        if (node == null) {
            return;
        }
        if (verticalNodeMap.containsKey(vertical)) {
            List<NodeData> tmpList = verticalNodeMap.get(vertical);
            tmpList.add(new NodeData(node.val, height));
            verticalNodeMap.put(vertical, tmpList);
        } else {
            List<NodeData> tmpList = new ArrayList<>();
            tmpList.add(new NodeData(node.val, height));
            verticalNodeMap.put(vertical, tmpList);
        }
        dfsHelpher(node.left, vertical - 1, height + 1);
        dfsHelpher(node.right, vertical + 1, height + 1);
    }
    
    
    
    public static void main(String[] args) {
        LC987VerticalOrderDFS obj = new LC987VerticalOrderDFS();
        TreeNode root = TreeUtil.constructBalancedBinaryTreeVertical();
        System.out.println(obj.verticalTraversal(root));
        //[[4,10,11],[3,6,7],[2,5,8,9],[0],[1]]
        
    }

}
