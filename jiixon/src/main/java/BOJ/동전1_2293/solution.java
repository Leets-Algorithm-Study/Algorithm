package main.java.BOJ.동전1_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //동전의 종류
        int k = Integer.parseInt(st.nextToken()); //가치의 합

        int[] coins = new int[n+1];
        int[] memo = new int[k+1];

        memo[0] = 1; //0원일 경우 경우의 수 1
        for(int i = 1; i<n+1; i++){
            coins[i] = Integer.parseInt(br.readLine());
            for(int j = coins[i]; j<k+1; j++){
                memo[j] = memo[j]+ memo[j-coins[i]];
            }
        }
        System.out.println(memo[k]);
    }
}
