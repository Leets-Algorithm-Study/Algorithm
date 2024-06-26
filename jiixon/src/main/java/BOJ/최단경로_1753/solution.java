package main.java.BOJ.최단경로_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
    int idx;
    int cost;

    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}
public class solution {
    //우선순위 큐 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        //간선만큼 그래프 설정
        for(int i = 0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }

        //그래프 초기화
        int u,v,m;
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,m));
        }

        //다익스트라 배열 초기화
        int[] dist = new int[V+1];
        for(int i = 0; i<=V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        //시작점이니까 비용은 0
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            if(dist[curNode.idx]<curNode.cost){
                continue;
            }

            //인접 노드 탐색
            for(int i = 0; i<graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx]> curNode.cost + nxtNode.cost){
                    dist[nxtNode.idx]= curNode.cost + nxtNode.cost;
                    //갱신된 경우에만 큐에 넣기
                    pq.offer(new Node(nxtNode.idx,dist[nxtNode.idx]));
                }
            }
        }

        for(int i = 1; i<V+1; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
