package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _13565 {
    static int m,n;
    static boolean[][] map;
    static int max = 1000 + 10;
    static boolean check = false;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new boolean[max][max];
        for(int i = 1 ; i <= m ; i ++){
            char[] str = sc.next().toCharArray();
            for(int j = 0; j < n; j ++){
                if (str[j] == '0'){
                    map[i][j+1] = true;
                }
            }
        }

        for(int i = 1; i <= m ; i ++){
            for(int j = 1; j <=n ; j ++){
                if (map[1][j]){
                    DFS(1,j,0);
                }
            }
        }
        if (check){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static void DFS(int x, int y, int l){
        if (x == m){
            check = true;
        }else{
            map[x][y] = false;
            for(int i = 0 ; i < 4;  i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (map[nx][ny]){
                    map[nx][ny] = false;
                    DFS(nx,ny,l +1);
                }
            }
        }
    }
}
