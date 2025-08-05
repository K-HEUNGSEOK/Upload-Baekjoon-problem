package silver.dfs_bfs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _2468 {
    static int[][] graph;
    static int n, ans, max, cnt;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 1; //만약 다 돌았는데도 0이면 1출력하면 됨
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                max = Math.max(max, graph[i][j]);
            }
        }
        for(int count = 0 ; count <= max; count ++){
            cnt =0;
            ch = new boolean[n][n]; //1차실수 -> for문 밖에다 초기화를 해서 한번밖에 작동을 안함
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < n ; j ++){
                    if (graph[i][j] > count && !ch[i][j]){ //여기서 ch체크를 안해서 정답이 안나왔었음
                        DFS(i,j,count);
                        cnt ++;
                    }
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }

    static void DFS(int x, int y, int height) {
            ch[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (isRange(nx, ny) && graph[nx][ny] > height && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    DFS(nx,ny,height);
                }
            }

    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}