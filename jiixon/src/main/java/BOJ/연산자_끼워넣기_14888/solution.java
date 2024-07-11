package main.java.BOJ.연산자_끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];

        //숫자 배열에 저장
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }




    }
}
