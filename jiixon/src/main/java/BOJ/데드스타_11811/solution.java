package main.java.BOJ.데드스타_11811;

import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // 행렬의 각 원소 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 주 대각선을 제외한 나머지 원소들의 비트 OR 결과 구하고 출력
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                result |= matrix[i][j];
            }
            System.out.print(result + " ");
        }
    }
}
