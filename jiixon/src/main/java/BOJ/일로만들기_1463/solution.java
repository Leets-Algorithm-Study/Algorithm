package main.java.BOJ.일로만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {
    //dp[i]는 숫자 i를 1로 만드는 데 필요한 최소 연산 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[n]);
    }
}
