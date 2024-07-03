package main.java.BOJ.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        if(n==0){
            System.out.println(wine[0]);
        }
        dp[0] = wine[0];
        if(n>1) {
            dp[1] = dp[0] + wine[1];
        }
        if(n>2){
            dp[2] = Math.max(Math.max(wine[0] + wine[1], wine[1] + wine[2]), wine[0] + wine[2]);
        }
        if(n>3){
            for(int i=3; i<n; i++){
                dp[i] = Math.max(Math.max(dp[i-1],dp[i-2]+wine[i]), dp[i-3]+wine[i]+wine[i-1]);
            }
        }

        System.out.println(dp[n-1]);
    }
}
