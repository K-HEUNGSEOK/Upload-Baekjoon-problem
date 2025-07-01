package silver.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _1051 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1. 입력하기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str[j] - '0';
            }
        }
        //2. 로직짜기
        int ans = 1; // 기본 정답
        int length = Math.min(n, m);

        //기본값이 1이기때문에 답은 2부터 시작한다. 2 ~ 정사각형을 만들 수 있는 최대 크기
        for (int side = 2; side <= length; side++) {
            for (int row = 0; row + side <= n; row++) {
                for (int col = 0; col + side <= m; col++) {
                    int v = arr[row][col];
                    if (v == arr[row][col + side - 1]//가로가 같고
                            && arr[row + side - 1][col] == v //세로가 같고
                            && arr[row + side - 1][col + side - 1] == v) { //오른쪽 아래가 같으면
                        ans = Math.max(ans, side * side);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
