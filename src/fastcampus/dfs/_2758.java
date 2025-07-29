package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _2758 {
    static int t, n, m, ans;
    static long[][] mem;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            ans = 0;
            mem = new long[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    mem[i][j] = -1;
                }
            }
            System.out.println(solve(n, m));

        }
    }

    static long solve(int i, int last) {
        if (last <= 0) return 0;
        if (i == 1) return last;
        if (mem[i][last] == -1){
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }
        return mem[i][last];
    }
}
