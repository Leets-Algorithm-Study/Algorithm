package main.java.BOJ.연산자_끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static int[] num;
    public static int n;
    public static int max, min;

    public static void backtracking(int result, int index, int plus, int minus, int multiply, int divide) {
        if (index == n) { //수를 다 돌았을 때,
            if (min > result) min = result;
            if (max < result) max = result;
            return;

        }
        if (plus > 0) {
            System.out.println(result);
            backtracking(result + num[index], index + 1, plus - 1, minus, multiply, divide);
        }
        if (minus > 0) {
            backtracking(result - num[index], index + 1, plus, minus - 1, multiply, divide);
        }
        if (multiply > 0) {
            backtracking(result * num[index], index + 1, plus, minus, multiply - 1, divide);
        }
        if (divide > 0) {
            backtracking(result / num[index], index + 1, plus, minus, multiply, divide - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //수의 개수
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        num = new int[n];
        int[] cal = new int[4];

        //숫자 배열에 저장
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        backtracking(num[0], 1, cal[0], cal[1], cal[2], cal[3]);

        System.out.println(max);
        System.out.println(min);


    }
}
