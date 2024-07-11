package main.java.BOJ.동전0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (k != 0) {
            for (int i = n - 1; i >= 0; i--) {
                if (value[i] > k) {
                    continue;
                }
                count += k / value[i]; //몫 만큼 저장
                k = k - value[i] * (k / value[i]);
            }
        }
        System.out.println(count);
    }
}
