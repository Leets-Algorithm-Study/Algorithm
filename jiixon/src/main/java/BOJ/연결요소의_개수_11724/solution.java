package main.java.BOJ.연결요소의_개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static void dfs(int start){
        //현재 노드 방문처리
        visited[start] = true;

        //인접노드 확인
        for(int i = 0; i<graph.get(start).size(); i++){
            int nxtNode = graph.get(start).get(i);
            if(!visited[nxtNode]){
                dfs(nxtNode); //재귀적으로 방문
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int u, v;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n+1];
        int count = 0;

        for(int i = 1; i<n+1; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
