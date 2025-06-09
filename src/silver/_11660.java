package silver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _11660 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] acc = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1; j <=n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <=n ; i ++){
            for(int j = 1; j<=n ; j ++){
                acc[i][j] = acc[i][j-1] + arr[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i ++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int sum = 0;
            for(int x = x1 ; x <= x2; x ++){
                sum += acc[x][y2] - acc[x][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}