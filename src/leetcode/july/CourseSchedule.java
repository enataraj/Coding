package leetcode.july;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	
	List<Integer>[] adj;
    boolean[] visited;
    boolean[] explored;
    int[] res;
    int count = 0;
    public int[] findOrder(int N, int[][] P) {
        adj = new ArrayList[N];
        visited = new boolean[N];
        explored = new boolean[N];
        res = new int[N];
        
        for(int i = 0 ;i<N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0;i<P.length;i++){
            adj[P[i][0]].add(P[i][1]);
        }
        for(int i =0;i<N;i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return new int[0];
                }
            }
        }
        // int[] ans = new int[N];
        // int count = 0;
        // for(int i : res)
        //     ans[count++] = i;
        return res;
    }
    public boolean isCyclic(int N){
        visited[N] = true;
        for(int i :adj[N]){
            if(!visited[i]){
                if(isCyclic(i))
                    return true;
            }
            else if(!explored[i])
                return true;
        }
        explored[N] = true;
        res[count++] = N;
        return false;
    }

}
