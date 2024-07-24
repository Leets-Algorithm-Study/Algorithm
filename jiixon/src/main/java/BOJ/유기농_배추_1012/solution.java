package main.java.BOJ.유기농_배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    static int m, n, k, count;
    static int[][] graph;
    public static void dfs(int x, int y) {
        //범위를 벗어났다면
        if(x<=-1 || x>=m || y<=-1 || y>=n) {
            return;
        }

        //배추 안심어진 곳이라면
        if(graph[y][x] == 0){
            return;
        }

        //현재 좌표 방문처리
        graph[y][x] = 0;

        //상하좌우 탐색
        dfs(x-1,y);
        dfs(x,y-1);
        dfs(x+1,y);
        dfs(x,y+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //테스트 갯수
        StringTokenizer st;
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //가로길이
            n = Integer.parseInt(st.nextToken()); //세로길이
            k = Integer.parseInt(st.nextToken()); //배추위치 갯수
            graph = new int[n][m]; //밭 만들기
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[Y][X] = 1;
            }

            count = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(graph[j][l] == 1) {
                        dfs(l, j);
                        count++;
                    }
                }
            }
            result[i] = count;
        }
        for(int i : result) System.out.println(i);
    }
}
