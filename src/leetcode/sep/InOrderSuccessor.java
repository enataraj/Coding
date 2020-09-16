package leetcode.sep;

public class InOrderSuccessor {

    public Node inorderSuccessor(Node node) {
        if (node == null)
            return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
        } else {
            while (node.parent != null) {
                if (node.parent.right == null || node.parent.right != node)
                    break;
                node = node.parent;
            }
            node = node.parent;
        }
        return node;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    
    public static void main(String[] args) {
        InOrderSuccessor obj = new InOrderSuccessor();
        
    }

}
