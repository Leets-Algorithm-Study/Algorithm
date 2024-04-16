package BOJ7658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[][] input = new int[num][2];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[num];

        for(int i=0; i<num; i++){
            for(int j=0; j< num; j++){
                if(i!=j){
                    if(input[i][0] < input[j][0] && input[i][1] < input[j][1]){
                        result[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < num; i++) {
            System.out.print((result[i] + 1) + " ");
        }
    }
}
