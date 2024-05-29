package main.java.BOJ.로봇청소기_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static int[][] room;
    public static int N,M, cleanCnt;
    public static int[] dx = {-1, 0, 1, 0}; //북동남서
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanCnt = 0;
        clean(r,c,d);
        System.out.println(cleanCnt);

    }
    public static void clean(int r, int c, int d){
        //현재 위치를 청소
        if (room[r][c] == 0) {
            room[r][c] = -1; //청소완료: -1
            cleanCnt++;
        }

        //4칸 중에 청소안된 0인 칸이 있는지 확인
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dx[d];
            int nc = c + dy[d];

            //청소되지 않은 빈 칸이 있는 경우
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
                clean(nr, nc, d);
                return;
            }
        }

        //청소할 곳이 없는 경우(혹은 벽인 경우)
        int backD = (d + 2) % 4;
        int br = r + dx[backD];
        int bc = c + dy[backD];

        //후진할 수 없는 경우 멈추기
        if (br >= 0 && br < N && bc >= 0 && bc < M && room[br][bc] != 1) {
            clean(br, bc, d); // 방향 그대로 후진
        }
    }
}
