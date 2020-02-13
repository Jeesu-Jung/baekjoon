package bj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] dfsIsVisited;
    static boolean[] bfsIsVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int vertexNum= Integer.parseInt(testCase[0]);
        int edgeNum= Integer.parseInt(testCase[1]);
        int rootNode= Integer.parseInt(testCase[2]);
        graph=new ArrayList[vertexNum+1];
        for(int i=0; i<vertexNum+1; i++){
            graph[i]=new ArrayList<>();
        }
        dfsIsVisited=new boolean[vertexNum+1];
        bfsIsVisited=new boolean[vertexNum+1];
        for(int i=0; i<edgeNum; i++){
            String[] edge=br.readLine().split(" ");
            int a= Integer.parseInt(edge[0]);
            int b= Integer.parseInt(edge[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1; i<vertexNum+1; i++){
            Collections.sort(graph[i]);
        }
        dfs(rootNode);
        System.out.println();
        bfs(rootNode);
    }
    public static void dfs(int vertex){
        System.out.print(vertex+" ");
        dfsIsVisited[vertex]=true;
        for(int i=0; i<graph[vertex].size(); i++){
            int nextVertex=graph[vertex].get(i);
            if(!dfsIsVisited[nextVertex]){
                dfs(nextVertex);
            }
        }
    }

    public static void bfs(int vertex){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(vertex);
        bfsIsVisited[vertex]=true;
        while(queue.size()!=0){
            int p=queue.poll();
            System.out.print(p+" ");
            for(int i=0; i<graph[p].size(); i++){
                int nextVertex=graph[p].get(i);
                if(!bfsIsVisited[nextVertex]){
                    queue.add(nextVertex);
                    bfsIsVisited[nextVertex]=true;
                }
            }
        }
    }
}