package leetcode.july;


import java.util.ArrayList;
import java.util.List;

public class AllPathSourceToDest {

    
    List<List<Integer>> ans=new  ArrayList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited=new boolean[graph.length];
        List<Integer> path=new ArrayList<Integer>();
        visited[0]=true;
        path.add(0);
        dfs(graph,visited,0,path);
        return ans;
    }
    public void dfs(int[][] graph,boolean[] visited,int u,List<Integer> path){
        if(u==graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<graph[u].length;i++){
            int v=graph[u][i];
            ///if(!visited[v]){
            visited[v]=true;
            path.add(v);
             dfs(graph,visited,v,path);
            visited[v]=false;
            path.remove(path.size()-1);//}
        }
    }
    
    
    
    
List<List<Integer>> result;
    
    // i = 3
    // [1,1,0,0]
    // <0, 1,3>
    // <0,2,
    
    
    public void bfs(int[][]graph, List<Integer> output1, int i){
        List<Integer> output = new ArrayList<>(output1);
        if(i == graph.length-1){
            output.add(i);
            result.add(output);
            return;
        }
        // if(visited[i] == 1)
        //     return;
        // visited[i] = 1;
        output.add(i);
        for(int t : graph[i]){
            bfs(graph,output,t);
        }
    }
    
    public List<List<Integer>> allPathsSourceTargetOpt1(int[][] graph) {
        int n = graph.length;
        if(n <= 1){
            return null;
        }
        
        result = new ArrayList<>();
        // int[] visited = new int[n];
        
        bfs(graph,new ArrayList<>(),0);
        
        return result;
    }
    
}
