package main.java.BOJ.최단경로_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solution_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        //간선만큼 그래프 설정
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 초기화
        int u, v, m;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, m));
        }

        //다익스트라 배열 초기화
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE; //비용 변수
            int nodeIdx = 0; //해당 인덱스 변수

            //최소 비용 값 노드 선정
            for (int j = 1; j < V + 1; j++) {
                if (!visited[j] && dist[j] < nodeValue){
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true; //방문처리

            //선택 노드의 인접 노드 탐색
            for(int j = 0; j<graph.get(nodeIdx).size(); j++ ){
                Node adjNode = graph.get(nodeIdx).get(j);

                //dist 배열 값 갱신
                if(dist[adjNode.idx]>dist[nodeIdx]+adjNode.cost){
                    dist[adjNode.idx] = dist[nodeIdx]+adjNode.cost;
                }
            }

        }

        //출력
        for(int i = 1; i<V+1; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
