package com.ppx.common.ppxutil.demos.hxp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    ArrayList<String> vertexList;
    int[][] edges;
    int numOfEdges;
    boolean[] isVisited;  //if vertex has been visited


    public static void main2(String[] args) {
        int n = 8;
        String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(n);
        for (String vertex : vertexs
        ) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();

        System.out.println("deep ");
        graph.dfs();
        System.out.println("widw");
        graph.bfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    void dfs(boolean[] isVisited, int i) {
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    void bfs(boolean[] isVisited, int i) {
        int u;  // list header nodes suffixlabel
        int w;  //neighbor
        LinkedList queue = new LinkedList();
        System.out.println(getValueByIndex(i) + "=>");

        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);

                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    private int getNumOfVertex() {
        return vertexList.size();
    }

    void showGraph() {
        for (int[] link :
                edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    int getNumOfEdges() {
        return numOfEdges;
    }

    private int getNextNeighbor(int v1, int v2) {
        for (int j = v2+1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    private void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
