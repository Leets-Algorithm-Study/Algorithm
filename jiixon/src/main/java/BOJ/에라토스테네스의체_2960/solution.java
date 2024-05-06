package main.java.BOJ.에라토스테네스의체_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solution {
    public static int n;
    public static ArrayList<Integer> remove;

    public static void eratosthenes(){
        int[] array = new int[n+1];
        remove = new ArrayList<>();
        //배열 채우기
        for(int i=2; i<=n; i++){
            array[i] = i;
        }

        for(int i=2; i<=n; i++){
            for(int j=i; j<=n; j+=i){
                if(array[j]==0) continue;
                remove.add(array[j]);
                array[j] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        eratosthenes();
        System.out.println(remove.get(k-1));
    }
}
