package graph.util;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int v;
    private List<List<Integer>> adjList;

    public Graph(int v) {
        this.v = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

    }

    public void addEdges(int v, int w) {
        adjList.get(v).add(w);
    }

}
