package 나이순_정렬_10814;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Member{
    int age;
    String name;

    public Member(int age, String name){
        this.age = age;
        this.name = name;
    }
}

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

    public static void sort(Member[] members){
        //Comparator 인스턴스 생성과 동시에 compare() 메서드를 오버라이드
        Arrays.sort(members, new Comparator<Member>() {
                    @Override
                    public int compare(Member o1, Member o2) {
                        if(o1.age == o2.age) return 0; // 나이 같으면 가입 순 그대로
                        return Integer.compare(o1.age, o2.age); //Integer.compare(a,b) -> a가 작으면 음수, 같으면 0, 크면 양수
                    }
                }
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        String[][] list = new String[testCnt][2];
        Member[] members = new Member[testCnt];
        for (int i = 0; i < testCnt; i++) {
            String age = sc.next();
            String name = sc.next();
            list[i][0] = age;
            list[i][1] = name;
            members[i] = new Member(Integer.parseInt(age), name);

        }

        //bubbleSort(list);
        //selectSort(list);
        sort(members); //메모리: 109444KB, 시간: 1816ms

//        for (String[] arr : list) {
//            System.out.println(arr[0] + " " + arr[1]);
//        }

        for(Member member: members){
            System.out.println(member.age + " "+ member.name);
        }
    }
}
