package leetcode.aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class VerticalOrderTraversal {

    private class Data implements Comparable<Data> {
        TreeNode node;
        int xpos;
        int ypos;

        public Data(TreeNode root, int xpos, int ypos) {
            this.node = root;
            this.xpos = xpos;
            this.ypos = ypos;

        }

        @Override
        public int compareTo(Data o) {
            return this.ypos - o.ypos;
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<Data> queue = new LinkedList<>();
        Map<Integer, List<Data>> map = new TreeMap<>();
        queue.add(new Data(root, 0, 0));

        List<Data> list;
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Data data = queue.poll();

                if (map.get(data.xpos) != null) {
                    list = map.get(data.xpos);
                    list.add(data);
                    map.put(data.xpos, list);
                } else {
                    list = new ArrayList<>();
                    list.add(data);
                    map.put(data.xpos, list);
                }

                if (data.node.left != null) {
                    queue.add(new Data(data.node.left, data.xpos - 1, data.ypos - 1));
                }
                if (data.node.right != null) {
                    queue.add(new Data(data.node.right, data.xpos + 1, data.ypos - 1));
                }

            }

            Collections.sort(list);

        }

        for (List<Data> list1 : map.values()) {
            List<Integer> tlist = new ArrayList<>();
            for (Data data : list1) {
                tlist.add(data.node.val);

            }

            result.add(tlist);
        }

        return result;

    }

    public List<List<Integer>> verticalTraversal_Sol(TreeNode root) {
        if (root == null)
            return new ArrayList();
        Queue<Map<TreeNode, Integer[]>> q = new LinkedList();
        Map<Integer, PriorityQueue<Integer[]>> map = new HashMap();
        Integer[] xy = new Integer[2];
        xy[0] = 0;
        xy[1] = 0;
        Map<TreeNode, Integer[]> elemMap = new HashMap();
        elemMap.put(root, xy);
        q.offer(elemMap);
        int minPos = 0;
        int maxPos = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Map.Entry<TreeNode, Integer[]> elem = getEntry(q.poll());
                TreeNode node = elem.getKey();
                xy = elem.getValue();
                if (node.left != null) {
                    elemMap = new HashMap();
                    elemMap.put(node.left, getLeft(xy));
                    q.offer(elemMap);
                }
                if (node.right != null) {
                    elemMap = new HashMap();
                    elemMap.put(node.right, getRight(xy));
                    q.offer(elemMap);
                }
                PriorityQueue<Integer[]> pq = map.getOrDefault(xy[0], new PriorityQueue<Integer[]>((elem1, elem2) -> {
                    if (elem1[1] == elem2[1])
                        return Integer.compare(elem1[0], elem2[0]);
                    else
                        return Integer.compare(elem2[1], elem1[1]);
                }));
                pq.offer(getPQEntry(elem));
                map.put(xy[0], pq);
                minPos = Math.min(xy[0], minPos);
                maxPos = Math.max(xy[0], maxPos);
            }
        }
        // System.out.println(map.toString());
        List<List<Integer>> ansList = new ArrayList();
        for (int i = minPos; i <= maxPos; i++) {
            if (map.containsKey(i)) {
                // ;
                // Collections.sort(ansMap.get(i));
                List<Integer> list = new ArrayList();
                PriorityQueue<Integer[]> pq = map.get(i);
                while (!pq.isEmpty()) {
                    list.add(pq.poll()[0]);
                }
                ansList.add(list);
            }
        }
        return ansList;
    }

    private Integer[] getPQEntry(Map.Entry<TreeNode, Integer[]> elem) {
        Integer[] arr = new Integer[2];
        arr[0] = elem.getKey().val;
        arr[1] = elem.getValue()[1];
        return arr;
    }

    private Map.Entry<TreeNode, Integer[]> getEntry(Map<TreeNode, Integer[]> elemMap) {
        Set<Map.Entry<TreeNode, Integer[]>> set = elemMap.entrySet();
        return set.iterator().next();
    }

    private Integer[] getLeft(Integer[] xy) {
        Integer[] xyl = new Integer[2];
        xyl[0] = xy[0] - 1;
        xyl[1] = xy[1] - 1;
        return xyl;
    }

    private Integer[] getRight(Integer[] xy) {
        Integer[] xyl = new Integer[2];
        xyl[0] = xy[0] + 1;
        xyl[1] = xy[1] - 1;
        return xyl;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal obj = new VerticalOrderTraversal();

        TreeNode root = TreeUtil.constructBinaryTreetmp();
        System.out.println(obj.verticalTraversal(root));
    }

}
