package main.java.BOJ.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] costArr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int cost = Integer.parseInt(st.nextToken());
                costArr[i][j] = cost;
            }
        }

        int[][] dp = new int[n][3];
        //기본 r,g,b로 설정
        dp[0][0] = costArr[0][0];
        dp[0][1] = costArr[0][1];
        dp[0][2] = costArr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costArr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costArr[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costArr[i][2];
        }
        int result = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(result);
    }
}
