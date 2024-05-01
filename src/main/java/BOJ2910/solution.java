package BOJ2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 메시지의 길이

        //c(메시지 최대길이)를 저장하니 더 메모리초과가 났음 , 최대 길이인 100001로 고정해서 배열크기를 설정하니 메모리초과가 나지않음
        st.nextToken(); //메시지 최대길이
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n]; //입력받는 수 배열
        int[] cntArr = new int[100001]; // 숫자의 빈도수를 저장하는 배열
        int[] original = new int[n];

        //입력받는 수 배열에 저장 및 빈도수도 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            original[i] = arr[i];
            cntArr[arr[i]]++;   //각 값에 대해 해당 카운팅 테이블의 값 수정
        }

        //빈도수를 기준으로 정렬 (+선택정렬)
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                //1)빈도수가 작으면 위치 바꾸기
                //2)빈도수가 같다면 원래 순서유지 -> 원래순서가 아닐 경우(arr[i]가 arr[j]보다 뒤에 있다면) 바꾸기
                if(cntArr[arr[i]]<cntArr[arr[j]] ||
                        (cntArr[arr[i]] == cntArr[arr[j]] && indexOf(original, arr[i]) > indexOf(original, arr[j]))){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }

        }
        // 정렬된 리스트를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    //주어진 수가 배열을 처음 저장할때 있던 인덱스 위치 반환하는 메서드
    private static int indexOf(int[] arr, int num){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == num) return i; //해당 인덱스 반환
        }
        return -1;
    }
}
