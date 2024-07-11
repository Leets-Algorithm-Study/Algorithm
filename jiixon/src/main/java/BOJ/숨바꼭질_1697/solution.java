package main.java.BOJ.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수빈이 위치
        int k = Integer.parseInt(st.nextToken()); //동생 위치


        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] distance = new int[100001];

        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            //원하는 위치 도달
            if (current == k) {
                System.out.println(distance[current]);
                return;
            }

            int[] nxtNode = {current * 2, current - 1, current + 1};
            for (int next : nxtNode) {
                //주의: !visited[next]부터 체크하면 런타임에러 (ArrayIndexOutOfBounds)
                if (next >= 0 && next <= 10000 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                }
            }
        }

    }
}
