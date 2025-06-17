package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _11724 {
    static int[][] graph;
    static boolean[] ch;
    static int n, m;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
      
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new boolean[n + 1];
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int i = 1 ; i<=n ; i ++){
            if (!ch[i]){
                DFS(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void DFS(int v) {
        if (v > n) {
            ans ++;
            return;
        } else {
            ch[v] = true;
            for(int i = 1; i <= n ; i ++){
                if (graph[v][i] == 1 && !ch[i]){
                    DFS(i);
                }
            }
        }
    }
}
