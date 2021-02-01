package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tree.util.TreeNode;

public class VerticalOrder {

    class NodeData {
        TreeNode node;
        int idx;

        public NodeData(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    int min = 0, max = 0;
    Map<Integer, List<Integer>> map = new HashMap();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null)
            return res;
        Queue<NodeData> queue = new LinkedList();

        queue.add(new NodeData(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> tmp = new HashMap();
            for (int i = 0; i < size; i++) {
                NodeData nodeData = queue.poll();
                TreeNode cur = nodeData.node;
                int idx = nodeData.idx;
                tmp.putIfAbsent(idx, new ArrayList<Integer>());
                tmp.get(idx).add(cur.val);
                if (idx < min)
                    min = idx;
                if (idx > max)
                    max = idx;
                if (cur.left != null) {

                    queue.add(new NodeData(cur.left, idx - 1));

                }
                if (cur.right != null) {
                    queue.add(new NodeData(cur.right, idx + 1));
                }
            }
            // different than the other question where here might have the same positions
            for (int key : tmp.keySet()) {
                // If two nodes have the same position, check the layer, the node on higher
                // level(close to root) goes first
                // if they also in the same level, order from small to large
                map.putIfAbsent(key, new ArrayList<Integer>());
                List<Integer> list = tmp.get(key);
                Collections.sort(list);
                map.get(key).addAll(list);
            }

        }
        for (int i = min; i <= max; i++) {
            List<Integer> list = map.get(i);
            res.add(list);
        }
        return res;
    }

}
