package main.java.BOJ.정수삼각형_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                int num = Integer.parseInt(st.nextToken());
                triangle[i][j] = num;
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i =1; i<n; i++){
            for(int j = 0; j<n; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
                }
            }
        }
        int result = dp[n-1][0];
        for(int i = 0; i<n; i++){
            if(result < dp[n-1][i]) result = dp[n-1][i];
        }
        System.out.println(result);

    }
}
