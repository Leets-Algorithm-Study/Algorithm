package main.java.BOJ.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] result = new int[t];


        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            //첫번째줄 스티커
            st = new StringTokenizer(br.readLine());
            for(int j = 0; i<n+1; j++){
                sticker[0][j]=Integer.parseInt(st.nextToken());
            }

            //두번째줄 스티커
            st = new StringTokenizer(br.readLine());
            for(int j = 0; i<n+1; j++){
                sticker[1][j]=Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][n];

            if(n==1){ //?? 고민중
                result[i] = Math.max(sticker[0][0],sticker[1][0]);
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            //.. 제 느낌상 이건데 ^^.. ㅠ점화식이 너무 어려워요 오늘밤까지만 한번 도전해볼게요 ㅜ 풀수 있을거같아서 경규님 코드는 안보겠슴다..



        }



    }
}
