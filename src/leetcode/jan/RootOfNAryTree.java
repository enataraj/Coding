package leetcode.jan;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RootOfNAryTree {

    public Node findRoot(List<Node> tree) {
        if (tree.size() == 1) {
            return tree.get(0);
        }

        Set<Integer> nodeWithParents = new HashSet<>();

        for (Node node : tree) {
            for (Node child : node.children) {
                nodeWithParents.add(child.val);
            }
        }

        for (Node node : tree) {
            if (!nodeWithParents.contains(node.val)) {
                return node; // this node doesn't have a parent, means it's a root
            }
        }

        return null; // should not reach here

    }

    public Node findRootAlt(List<Node> tree) {
        int xor = 0;

        for (Node node : tree) {
            xor ^= node.val;

            for (Node child : node.children) {
                xor ^= child.val;
            }
        }

        for (Node node : tree) {
            if (node.val == xor) {
                return node;
            }
        }

        return null; // should not reach here
    }

    class Node {
        int val;
        List<Node> children;
    }

    public static void main(String[] args) {
        RootOfNAryTree obj = new RootOfNAryTree();
    }

}
