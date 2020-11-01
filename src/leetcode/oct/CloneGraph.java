package leetcode.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
    
    public Node cloneGraph(Node node) {
        
        if (node == null) {
          return node;
      }
      Map<Node, Node> cloneMap = new HashMap<>();
      Queue<Node> q = new LinkedList<>();
      q.add(node);
      Set<Node> visited = new HashSet<>();
      visited.add(node);
      
      while (!q.isEmpty()) {
          Node origNode = q.poll();
          cloneMap.putIfAbsent(origNode, new Node(origNode.val));
          Node cloneNode = cloneMap.get(origNode);
          
          for (Node child : origNode.neighbors) {
              cloneMap.putIfAbsent(child, new Node(child.val));
              cloneNode.neighbors.add(cloneMap.get(child));
              
              if (!visited.contains(child)) {
                  visited.add(child);
                  q.add(child);
              }
          }
      }
      
      return cloneMap.get(node);
      
  }

    
   
    public Node cloneGraphApp2(Node node) {
        if(node == null){
            return null;
        }
        
    
        //Use bfs to get all graph nodes
        List<Node> nodes = getNodes(node);
        
        if(nodes.isEmpty()){
            return new Node(node.val);
        }
        
        //Use a map to store original node and copy node
        Map<Node, Node> map = new HashMap<>();
        
        //copy node first
        for(Node cur : nodes){
            map.put(cur, new Node(cur.val));
        }
        
        //copy neighbors
        for(Node cur : nodes){
            Node newNode = map.get(cur);
            for(Node neighbor : cur.neighbors){
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
        
        
    }
    
    private List<Node> getNodes(Node node){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        
        queue.offer(node);
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            for(Node neighbor : cur.neighbors){
                if(!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
            
        }
        
        return new ArrayList<>(set);
    }
    
}

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
