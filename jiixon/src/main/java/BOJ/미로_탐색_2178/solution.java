package main.java.BOJ.미로_탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
public class solution { //메모리:14724KB 시간:132ms
    public static int[][] graph;
    public static int n,m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int bfs(int x, int y){

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y)); //현재 좌표 queue에 넣음

        while (!queue.isEmpty()){
            Node current = queue.poll();
            x = current.getX();
            y = current.getY();

            for(int i = 0; i<4; i++){
                //상하좌우에 따른 위치 nx, ny
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<=-1 || nx>=n || ny<=-1 || ny>=m){ //위치가 범위 밖에 있으면
                    continue;
                }
                if(graph[nx][ny] == 0){ //위치가 갈 수 없는 곳이면
                    continue;
                }
                if(graph[nx][ny] == 1){ //위치가 갈 수 있는 곳이라면
                    graph[nx][ny] = graph[x][y] + 1; //기존 값에 +1 해서 오른쪽 아래방향으로 이동하면서 count
                    queue.offer(new Node(nx,ny));
                }
            }
        }
        return graph[n-1][m-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        //이차원 배열 입력받고 저장
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0;j<m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0)); //시작점부터최단거리 반환

    }
}
