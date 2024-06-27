package main.java.BOJ.특정거리의_도시찾기_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //도시 갯수
        int m = Integer.parseInt(st.nextToken()); //도로 갯수
        int k = Integer.parseInt(st.nextToken()); //거리정보(도달해야하는 거리)
        int x = Integer.parseInt(st.nextToken()); //출발 도시

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); //-1로 초기화
        distance[x] = 0;
        queue.add(x);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (distance[next] == -1) { // 아직 방문하지 않은 도시라면
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        // 거리 k인 모든 도시를 출력
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}