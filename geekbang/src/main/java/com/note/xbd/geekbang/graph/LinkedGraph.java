package com.note.xbd.geekbang.graph;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedGraph {

    private int v;//图的顶点数量
    private LinkedList<Integer> adj[];//邻接表

    public LinkedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图两条边
     *
     * @param form
     * @param to
     */
    public void addEdge(int form, int to) {
        adj[form].add(to);
        adj[to].add(form);
    }

    /**
     * 广度优先（Breadth First Search）
     *
     * @param s 起始顶点
     * @param t 目标顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //记录已经被访问过的顶点，访问后就设置为true
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //已经访问，但是顶点还没有访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q==t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 递归打印s->t的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "\t");
    }

    private boolean found  = false;

    public void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found == true){
            return;
        }
        visited[w] = true;
        if(w==t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }

    public static void main(String[] args) {
        LinkedGraph graph = new LinkedGraph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(6,7);
        graph.addEdge(5,7);

        graph.bfs(0,4);
        System.out.println("");
        graph.dfs(0,4);
    }
}
