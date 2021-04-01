package general;

public class LC427ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        int x1 = 0;
        int y1 = 0;
        int x2 = grid.length - 1;
        int y2 = grid.length - 1;

        Node node = null;

        if (isLeaf(grid, x1, y1, y2, y2)) {
            boolean val;
            if (grid[x1][y1] == 0) {
                val = false;
            } else {
                val = true;
            }
            node = new Node(val, true);
        } else {
            node = new Node(false, false);
            if (isLeaf(grid, x1, y1, x2 / 2, y2 / 2)) // top left
            {
                boolean val;
                if (grid[x1][y1] == 0) {
                    val = false;
                } else {
                    val = true;
                }
                Node topLeft = new Node(val, true);
                node.topLeft = topLeft;
            }

            if (isLeaf(grid, x2 / 2, 0, x2, y2 / 2)) // bottom left
            {
                boolean val;
                if (grid[x1][y1] == 0) {
                    val = false;
                } else {
                    val = true;
                }
                Node bottomLeft = new Node(val, true);
                node.bottomLeft = bottomLeft;

            }
            if (isLeaf(grid, 0, y2 / 2, x2 / 2, y2))// top right
            {

                boolean val;
                if (grid[x1][y1] == 0) {
                    val = false;
                } else {
                    val = true;
                }
                Node topRight = new Node(val, true);
                node.topRight = topRight;
            }
            if (isLeaf(grid, x1 / 2, y1 / 2, x2 / 2, y2 / 2)) // bottom right
            {
                boolean val;
                if (grid[x1][y1] == 0) {
                    val = false;
                } else {
                    val = true;
                }
                Node bottomRight = new Node(val, true);
                node.bottomRight = bottomRight;

            }

        }
        return node;
    }

    private boolean isLeaf(int[][] grid, int x1, int x2, int y1, int y2) {
        boolean ones = false;
        boolean zeros = false;
        for (int i = x1; i < y1; i++) {
            for (int j = x2; j < y2; j++) {
                if (grid[i][j] == 1) {
                    ones = true;
                } else if (grid[i][j] == 0) {
                    zeros = true;
                }

                if (ones && zeros) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    public Node constructSol(int[][] grid) {
        int n = grid.length;
        return getNode(grid, 0, n -1, 0, n - 1);
    }
    
    public Node getNode(int[][] grid, int top, int bottom, int left, int right){
        // leaf
        if(top > bottom || left > right) return null;
        if(left == right || top == bottom) return new Node(grid[top][left] == 1, true);
        
        // not leaf 
        int midH = (top + bottom) / 2;
        int midV = (left + right) / 2;
        
        Node topLeft = getNode(grid, top, midH, left, midV);
        Node topRight = getNode(grid, top, midH, midV + 1, right);
        Node bottomLeft = getNode(grid, midH + 1, bottom, left, midV);
        Node bottomRight = getNode(grid, midH + 1, bottom, midV + 1, right);
        
        
        boolean isLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        
        boolean val1 = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val;
        if(val1 && isLeaf){
           return new Node(true, true);
        }
        
        boolean val2 = !topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val;
        if(val2 && isLeaf){
            return new Node(false, true);
        }
        
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    
    
    public Node constructSol2(int[][] grid) {
        return constructTree(grid, 0, 0, grid.length);   
    }
    
    public Node constructTree(int[][] grid, int x, int y, int len){
        if(len == 1)
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        
        Node node = new Node();
        Node topLeft = constructTree(grid, x, y, len/2);
        Node topRight = constructTree(grid, x, y + len/2, len/2);
        Node bottomLeft = constructTree(grid, x + len/2, y, len/2);
        Node bottomRight = constructTree(grid, x+ len/2, y +len/2, len/2);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val){
            node.val = topLeft.val;
            node.isLeaf = true;
        }
        else{
        node.topLeft = topLeft;
        node.topRight = topRight;
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;
        }
    return node;
    }

    
}
