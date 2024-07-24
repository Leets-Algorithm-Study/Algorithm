package main.java.BOJ.N과M_2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static int[] array;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void backtracking(int n, int m, int k, int depth){
        if(m==depth){
            for(int i: array){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = k; i<=n; i++){
            if(!visited[i-1]){
                visited[i-1] = true;
                array[depth] = i;
                backtracking(n,m,i+1,depth+1);
                visited[i-1] = false;
             }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //숫자의 개수
        int m = Integer.parseInt(st.nextToken()); //수열 길이

        array = new int[m];
        visited = new boolean[n];

        backtracking(n, m, 1,0);
        System.out.println(sb);
    }
}
