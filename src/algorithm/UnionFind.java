package algorithm;

public class UnionFind {
    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }

}


class UnionFind1{
    
    int[] father;
    int count ;
    public UnionFind1(char[][] grid){
        father = new int[grid.length * grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    int id = i * grid[0].length + j;
                    father[id] = id;
                    count++;
                }
            }
        }
    }
    
    public void union(int x, int y){
        int find_x = find(x);
        int find_y = find(y);
        if(find_x != find_y){
            father[find_x] = find_y;
            count--;
        }
    }
    
    public int find(int node){
        if (father[node] == node) return node;
        father[node] = find(father[node]);
        return father[node];
    }
}
