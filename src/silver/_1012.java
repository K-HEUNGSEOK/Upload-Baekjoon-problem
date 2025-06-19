package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _1012 {
    static int n, m,t,k,ans;
    static boolean[][] map;
    static boolean[][] ch;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int z = 0 ; z < t; z ++){
            ans = 0;
            m = sc.nextInt(); //가로
            n = sc.nextInt(); //세로
            k = sc.nextInt(); //갯수
            map = new boolean[60][60];
            ch = new boolean[60][60];
            for(int i = 0; i < k ; i ++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y+1][x+1] = true;
            }
            //dfs 수행
            for(int i = 1; i<= n ; i++){
                for(int j = 1; j <=m ; j++){
                    if (!ch[i][j] && map[i][j]){
                        ans ++;
                        DFS(i,j);
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        //출력
        System.out.println(sb);
    }
    static void DFS(int i, int j){
        //상 -> i -1 , 하 -> i +1 , 좌 -> j -1 , 우 -> j + 1
        ch[i][j] = true;
        for(int z = 0 ; z < 4; z ++){
            int nx = i + dx[z];
            int ny = j + dy[z];
            if (map[nx][ny] && !ch[nx][ny]){
                DFS(nx,ny);
            }
        }
    }
}
