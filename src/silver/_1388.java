package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _1388 {
    static int n, m, ans;
    static int[] dx = {-1, 1};
    static int[] dy = {-1, 1};
    static boolean [][]visited;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = 0;
        graph = new char[60][60];
        visited = new boolean[60][60];
        for(int i = 1 ; i <= n ; i ++){
           char[] str = sc.next().toCharArray();
           for(int j = 1; j <= m ; j ++){
               graph[i][j] = str[j-1];
           }
        }
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= m ; j ++){
                if ((graph[i][j] == '-' || graph [i][j] =='|') && !visited[i][j]){
                    ans++;
                    DFS_Width(i,j);
                }
            }
        }
        System.out.println(ans);
    }

    static void DFS_Width(int x, int y) {
        visited[x][y] = true;
        char current = graph[x][y];
        if (current == '-'){
            for(int i = 0 ; i < 2; i ++){
                int ny = y + dy[i];
                if (graph[x][ny] == '-' && !visited[x][ny]){
                    visited[x][y] = true;
                    DFS_Width(x,ny);
                }
            }
        }else {
            for(int i = 0 ; i < 2; i ++){
                int nx = x + dx[i];
                if (graph[nx][y] == '|' && !visited[nx][y]){
                    visited[nx][y] = true;
                    DFS_Width(nx,y);
                }
            }
        }

    }
}
