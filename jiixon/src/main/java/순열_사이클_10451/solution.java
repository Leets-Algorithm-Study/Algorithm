package 순열_사이클_10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static boolean visited[];
    public static int[] array;

    public static void dfs(int x){
        if(visited[x-1]) return;

        visited[x-1] = true;
        dfs(array[x-1]);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int result[] = new int[t];
        for(int i = 0; i<t; i++){
            int size = Integer.parseInt(br.readLine());

            array = new int[size+1];
            visited = new boolean[size+1];

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<size; j++){
                array[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j<size; j++){
                if(!visited[j-1]) {
                    dfs(j);
                    result[i]++;
                }
            }
        }
        for(int i : result) System.out.println(i);
    }
}
