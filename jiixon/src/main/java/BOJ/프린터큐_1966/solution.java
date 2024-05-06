package main.java.BOJ.프린터큐_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    public static void main(String[] args) throws IOException {
        int m, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{j,priority}); //문서 순서와 중요도 넣기
            }

            int result = 0;
            while(!queue.isEmpty()){
                int[] poll = queue.poll(); //맨 위꺼 꺼내기
                boolean print = true;

                for(int[] next: queue){ //현재 문서보다 중요도가 높은 문서가 있는지 확인
                    if(next[1]>poll[1]){
                        print = false; //현재문서는 출력 못함
                        break;
                    }
                }

                if(print){ //중요도 가장 높은 문서일 경우
                    result++; //인쇄 횟수++
                    if(poll[0]==n) { //해당 문서가 원하는 문서일 경우
                        sb.append(result).append("\n");
                        break;
                    }
                }
                else{  //다시 큐에 넣기
                    queue.offer(poll); //push: LinkedList 앞에 요소 추가, offer: LinkedList 뒤에 요소 추가
                }
            }
        }
        System.out.println(sb);
    }
}
