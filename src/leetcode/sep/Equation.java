package leetcode.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Equation {

    private double dfs(double value, Map<String, Map<String, Double>> graph, String start, String end,
            Set<String> visited) {

        visited.add(start);
        Map<String, Double> map = graph.get(start);
        if (map.containsKey(end)) {
            return value * map.get(end);
        }

        for (String s : map.keySet()) {
            if (!visited.contains(s)) {
                double val = dfs(value * map.get(s), graph, s, end, visited);
                if (val != -1.0) {
                    return val;
                }
            }

        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];

        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            double val = values[i];
            String a = list.get(0);
            String b = list.get(1);

            graph.putIfAbsent(a, new HashMap<String, Double>());
            graph.putIfAbsent(b, new HashMap<String, Double>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1 / val);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> lt = queries.get(i);
            String a = lt.get(0);
            String b = lt.get(1);
            double cal = 1.0;
            Set<String> visited = new HashSet<>();
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                cal = -1.0;
            } else if (!a.equals(b)) {
                cal = dfs(cal, graph, a, b, visited);
            }
            result[i] = cal;
        }

        return result;
    }
    
    
    
    
    private class Data {
        double q;
        String b;
        
        Data(String b, double q) {
            this.b = b;
            this.q = q;
        }
    }
    
    public double[] calcEquationBFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n = equations.size();
        Map<String, List<Data>> graph = new HashMap<>();
        
        double[] res = new double[queries.size()];
        
        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            graph.putIfAbsent(eq.get(0), new ArrayList<>());
            graph.putIfAbsent(eq.get(1), new ArrayList<>());
            graph.get(eq.get(0)).add(new Data(eq.get(1), values[i]));
            graph.get(eq.get(1)).add(new Data(eq.get(0), 1.0 / values[i]));
        }
        
        for (int i = 0; i < queries.size(); i++) {
            res[i] = bfs(graph, queries.get(i).get(0), queries.get(i).get(1));
        }
        
        return res;
    }
    
    private double bfs(Map<String, List<Data>>graph, String lhs, String rhs) {
        if (!graph.containsKey(lhs) || !graph.containsKey(rhs)) {
            return -1.0;
            
        } else if (lhs.equals(rhs)) {
            return 1.0;
            
        }
        
        Set<String> visited = new HashSet<>();
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(lhs, 1.0));
        visited.add(lhs);
        
        while (!q.isEmpty()) {
            Data cur = q.poll();
            if (cur.b.equals(rhs)) {
                return cur.q;
            }
            
            if (graph.containsKey(cur.b)) {
                for (Data next : graph.get(cur.b)) {
                    if (!visited.contains(next.b)) {
                        visited.add(next.b);
                        q.add(new Data(next.b, cur.q * next.q));
                    }
                }
            }
        }
        
        return -1.0; // should not reach here
    }
    
    
    class Pair {
        String str;
        double val;
        public Pair(String str, double val) {
            this.str = str;
            this.val = val;
        }
        public String toString() {
            return str + ": " + val;
        }
    }
    
    public double[] calcEquationIrina(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>();
        int idx = 0;
        for (List<String> e : equations) {
            addEdge(adj, e.get(0), e.get(1), values[idx++]);
        }
        //System.out.println(adj);
        int n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> q = queries.get(i);
            if (adj.containsKey(q.get(0)) && adj.containsKey(q.get(1)))
                ans[i] = bfsIrina(adj, q.get(0), q.get(1));
            else
                ans[i] = -1.0;
        }
        return ans;
    }
    
    private double bfsIrina(Map<String, List<Pair>> adj, String s, String t) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.add(new Pair(s, 1.0));
        seen.add(s);
        while (!q.isEmpty()) {
            Pair el = q.poll();
            if (el.str.equals(t)) return el.val;
            for (Pair n : adj.get(el.str)) {
                if (!seen.contains(n.str)) {
                    q.add(new Pair(n.str, n.val * el.val));
                    seen.add(n.str);
                }
            }
        }
        return -1.0;
    }
    
    private void addEdge(Map<String, List<Pair>> adj, String a, String b, double val) {
        if (!adj.containsKey(a)) adj.put(a, new ArrayList<Pair>());
        if (!adj.containsKey(b)) adj.put(b, new ArrayList<Pair>());
        adj.get(a).add(new Pair(b, val));
        adj.get(b).add(new Pair(a, 1 / val));
    }

}
