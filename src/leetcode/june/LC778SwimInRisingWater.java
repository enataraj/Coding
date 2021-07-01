package leetcode.june;

import java.util.PriorityQueue;

public class LC778SwimInRisingWater {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    class Data implements Comparable<Data> {
        int row;
        int col;
        int val;

        public Data(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Data data) {
            if (this.val > data.val)
                return 1;
            return -1;
        }

        @Override
        public String toString() {

            return "(" + row + "," + col + "," + val + ")";
        }
    }

    public int swimInWater(int[][] grid) {

        int result = 0;
        int N = grid.length;
        PriorityQueue<Data> queue = new PriorityQueue<>();
        queue.add(new Data(0, 0, grid[0][0]));
        boolean[][] isVisited = new boolean[N][N];
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Data data = queue.poll();
            result = Math.max(result, data.val);
            if (data.row == N - 1 && data.col == N - 1) {
                return result;
            }

            for (int[] dir : dirs) {
                int newRow = data.row + dir[0];
                int newCol = data.col + dir[1];
                if (isValid(isVisited, newRow, newCol, N)) {
                    isVisited[newRow][newCol] = true;
                    queue.add(new Data(newRow, newCol, grid[newRow][newCol]));
                }

            }

        }

        return result;
    }

    private boolean isValid(boolean[][] isVisited, int row, int col, int N) {
        if (row >= 0 && row < N && col >= 0 && col < N && !isVisited[row][col]) {
            return true;
        }
        return false;
    }

    /*
     * 
     * Alternate Approach,
     * 
     * Try to go with Binary serach
     * 
     * Initally the max possible value is N^2 , Pick the middle and see with middle value you can reach the destination 
     * 
     * If not pick another number higher than the mid. 
     * 
     * If reachable try to reduce and apply DFS to see you can reachable.
     * 
     * C++ Code
     * 
     * 
     * 
     * 
     vector<vector<int>> dr = {{1,0},{0,1},{-1,0},{0,-1}};
    class Solution {
    public:  
    bool canReach(vector<int> &visited, vector<vector<int>> &grid,  int wt, int i, int j)
    {
    int N = grid.size();
    if(i==N-1 && j==N-1) return true;    
    visited[i*N+j]=1;
    for(auto d:dr) {
      int ni=d[0]+i, nj=d[1]+j;
      if(ni>=0 && ni<N && nj>=0 && nj<N &&visited[ni*N+nj]==0 && grid[ni][nj]<=wt) {
        if(canReach(visited, grid, wt, ni, nj)) 
           return true;
      }
    }
    return false;
    }
    
    int swimInWater(vector<vector<int>>& grid) 
    {
      int N=grid.size();
      vector<int>visited(N*N,0);      
      int left=0, right=N*N-1;      
      while(left<=right) {
        if(left==right) return left;
        int mid=left+(right-left)/2;
        fill(visited.begin(), visited.end(),0);
        if(grid[0][0]<=mid && canReach(visited, grid, mid, 0,0)) {
          right=mid;
        }
        else {
          left=mid+1;
        }
      }
      return -1;
    }
    };
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    
    // Union Find  Kruskal's Algorithm/Minimum Spanning Tree
    
    /*
     * vector<vector<int>> dr = {{1,0},{0,1},{-1,0},{0,-1}};
class Solution {
public:
  vector<int> parent;  
  int getParent(int i)
  {
    if(parent[i]!=i) {
      parent[i] = getParent(parent[i]);
    }
    return parent[i];
  }
  
  void union_n(int i, int j) 
  {
    int pi = getParent(i);
    int pj = getParent(j);
    if(pi==pj) return;    
    parent[pi] = pj;
  }
​
  int swimInWater(vector<vector<int>>& grid) 
  {
    int N = grid.size();
    parent.resize(N*N);
    iota(parent.begin(), parent.end(),0);        
    auto cmp=[](pair<int, int> &f, pair<int, int> &s)    {
      return f.first>s.first;
    };
    
    priority_queue<pair<int,int>, vector<pair<int,int>>,decltype(cmp)>myPq(cmp);    
    for(int i=0;i<N*N; i++) {
      myPq.push(pair<int,int>(grid[i/N][i%N], i));
    }    
    int ret=0;
    while(getParent(0)!=getParent(N*N-1)) {
      auto top = myPq.top();myPq.pop();
      ret=top.first;
      int i=top.second/N;
      int j=top.second%N;
      for(auto d:dr) {
        int ni=i+d[0], nj=j+d[1];
        if(ni>=0 && ni<N && nj>=0 && nj<N && grid[ni][nj]<=ret) {
          union_n(top.second, ni*N+nj);
        }
      }      
    }
    return ret;
  }
};
     */
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 } };
        LC778SwimInRisingWater obj = new LC778SwimInRisingWater();
        System.out.println(obj.swimInWater(grid));
    }

}
