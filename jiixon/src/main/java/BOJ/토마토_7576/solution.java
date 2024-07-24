package main.java.BOJ.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class solution {
    static int[][] box;
    static LinkedList<Node> queue = new LinkedList<>();
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs() {
        int result = 0;
        while (!queue.isEmpty()) {

            Node current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx <= -1 || nx >= m || ny <= -1 || ny >= n) { //범위에서 벗어난다면
                    continue;
                }

                if (box[nx][ny] == -1) { //토마토가 없는 칸이라면
                    continue;
                }

                if (box[nx][ny] == 0) { //갈 수 있는 곳이라면
                    queue.offer(new Node(nx, ny)); //전부 넣기
                    box[nx][ny] = box[current.x][current.y] + 1;
                }
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 0) { //안익은 토마토가 있다면
                    return -1;
                }
                result = Math.max(result, box[i][j]);
            }
        }
        return result-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //가로(열)
        m = Integer.parseInt(st.nextToken()); //세로(행)
        box = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        System.out.println(bfs());
    }
}
