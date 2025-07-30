package solved.class3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _21736 {
    static int n,m,cnt;
    static char[][] arr;
    static boolean[][] ch;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        ch = new boolean[n][m];
        cnt = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.next().toCharArray();
        }
        int x = 0;
        int y = 0;
        //1. 도연이 위치부터 찾기
        for(int i = 0; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if (arr[i][j] == 'I'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        DFS(x,y);

        if (cnt == 0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }
    }

    static void DFS(int x, int y){
        if (!isRange(x,y)) return;
        if (ch[x][y] || arr[x][y] == 'X') return;

        ch[x][y] =true; //방문처리
        if (arr[x][y] == 'P') cnt ++;
        for(int i = 0; i < 4; i ++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isRange(nx,ny) && !ch[nx][ny]){
                DFS(nx,ny);
            }
        }
    }
    static boolean isRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
