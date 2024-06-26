package main.java.BOJ.특정거리의_도시찾기_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //도시 갯수
        int m = Integer.parseInt(st.nextToken()); //도로 갯수
        int k = Integer.parseInt(st.nextToken()); //거리정보(도달해야하는 거리)
        int x = Integer.parseInt(st.nextToken()); //출발 도시
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

        }
    }
}
