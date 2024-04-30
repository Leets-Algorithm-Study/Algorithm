package BOJ2910;

import java.util.Scanner;

public class solution {

    public static void bubbleSort(String[][] list) {
        int len = list.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                //나이증가 순으로 정렬
                if (Integer.parseInt(list[j][0]) > Integer.parseInt(list[j + 1][0])) {
                    String[] tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                }
            }
        }

    }

    public static void selectSort(String[][] list){
        int len = list.length;
        for(int i = 0; i<len-1; i++){
            int minIndex = i;

            for(int j = i+1; j<len; j++){
                if(Integer.parseInt(list[minIndex][0])>Integer.parseInt(list[j][0])){
                    minIndex = j; //가장 작은 인덱스 찾기
                }
            }

            //가장 작은수랑 i번째랑 바꾸기
            String[] tmp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = tmp;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        String[][] list = new String[testCnt][2];
        for (int i = 0; i < testCnt; i++) {
            list[i][0] = sc.next(); //나이
            list[i][1] = sc.next(); //이름
        }

        bubbleSort(list);
        //selectSort(list);

        for (String[] arr : list) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
