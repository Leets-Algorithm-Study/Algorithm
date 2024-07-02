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

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; i<3; i++){
                int cost = Integer.parseInt(st.nextToken());
                costArr[i][j] = cost;
            }
        }

        int[][] dp = new int[n][3];







    }
}
