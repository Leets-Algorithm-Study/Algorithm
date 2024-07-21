package main.java.BOJ.안전영역_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    static int[][] arr;
    static int n, h, count, maxHeight;

    static void dfs(int x, int y, int h, boolean[][] visited) {

        //범위 밖이라면 무시
        if (x <= -1 || x >= n || y <= -1 || y >= n) {
            return;
        }

        //갔던 곳이거나 이미 잠겼으면 무시
        if (visited[x][y] || arr[x][y] <= h) {
            return;
        }

        visited[x][y] = true;
        dfs(x - 1, y, h, visited);
        dfs(x, y - 1, h, visited);
        dfs(x + 1, y, h, visited);
        dfs(x, y + 1, h, visited);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < arr[i][j]) maxHeight = arr[i][j]; //최대 높이값 설정
            }
        }


        int maxCount = 1;
        for (int h = 0; h <= maxHeight; h++) {
            boolean[][] visited = new boolean[n][n]; //방문 체크
            count = 0; //안전영역 개수

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > h) {
                        dfs(i, j, h, visited);
                        count++;
                    }
                }
            }
            if (maxCount < count) maxCount = count;
        }

        System.out.println(maxCount);


    }
}
