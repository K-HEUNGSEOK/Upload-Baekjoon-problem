package silver.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _10157 {
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int x, y,k;
    static int[][] arr;
    static int move = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt(); //가로
        x = sc.nextInt(); // 세로
        arr = new int[x][y];
        k = sc.nextInt(); //target;

        int cnt = 1;
        int x1 = x-1;
        int y1 = 0;
        arr[x1][y1] = cnt ++;
        while (cnt <= x * y){
            int nx = x1 + dx[move];
            int ny = y1 + dy[move];
            if (!isRange(nx,ny) || arr[nx][ny] != 0){
                move = (move + 1) % 4 ;
                nx = x1 + dx[move];
                ny = y1 + dy[move];
            }
            arr[nx][ny] = cnt ++;
            x1 = nx;
            y1 = ny;
        }
        boolean flag = false;
        for(int i = 0 ; i < x; i ++){
            for(int j = 0; j < y ; j ++){
                if (arr[i][j] == k){
                    flag = true;
                    System.out.println((j + 1) + " " + (x - i));
                    break;
                }
            }
        }
        if (!flag){
            System.out.println(0);
        }
    }
    static boolean isRange(int nx, int ny){
        return 0 <= nx && nx < x && 0 <= ny && ny < y;
    }
}
