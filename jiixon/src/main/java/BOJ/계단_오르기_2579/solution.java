package main.java.BOJ.계단_오르기_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[301];
        memo = new int[301];
        for(int i = 1; i<n+1; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        //초기값 설정
        memo[1] = stairs[1];
        memo[2] = Math.max(stairs[1], stairs[1]+stairs[2]);
        memo[3] = Math.max(stairs[2]+stairs[3], stairs[1]+stairs[3]);

        for(int i = 4; i<n+1; i++){
            memo[i] = Math.max(memo[i-2]+stairs[i],memo[i-3]+stairs[i-1]+stairs[i]); //두가지 중에 최댓값 골라서 memo에 저장
        }

        System.out.println(memo[n]);
    }
}
