package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _16173 {
    static int [][] graph;
    static int n;
    static int [] dx = {1,0};
    static int [] dy = {0,1};
    static int max = 3 + 110;
    static boolean[][] visited;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        graph = new int[max][max];
        visited = new boolean[max][max];
        n = sc.nextInt();
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= n ; j ++){
                graph[i][j] = sc.nextInt();
            }
        }
        DFS(1,1);
        if (visited[n][n]){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }
    static void DFS(int x , int y){
        if (x > n && y > n ){
            return;
        }else{
            visited[x][y] = true;
            for(int i = 0 ; i < 2; i ++){
                int nx = x + dx[i] * graph[x][y]; //덧셈을 하게되면 1칸 더 가게 됨
                int ny = y + dy[i] * graph[x][y];
                if (!visited[nx][ny]){
                    DFS(nx,ny);
                }
            }
        }
    }
}
