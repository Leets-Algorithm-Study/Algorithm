package main.java.BOJ.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] result = new int[t];


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            //스티커줄 입력받기
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                sticker[0][j] = Integer.parseInt(st1.nextToken());
                sticker[1][j] = Integer.parseInt(st2.nextToken());
            }

            int[][] dp = new int[2][n];

            if(n==1){
                result[i] = Math.max(sticker[0][0], sticker[1][0]);
                continue;
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(sticker[0][j] + dp[1][j-1], sticker[0][j]+ dp[1][j-2]);
                dp[1][j] = Math.max(sticker[1][j] + dp[0][j-1], sticker[1][j]+ dp[0][j-2]);
            }
            result[i] = Math.max(dp[0][n-1],dp[1][n-1]);
        }
        for(int r : result){
            System.out.println(r);
        }
    }
}
