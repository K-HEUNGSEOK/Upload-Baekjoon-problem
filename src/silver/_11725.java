package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _11725 {
    static int n;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        graph = new ArrayList<>();
        n = sc.nextInt();
        ch = new boolean[n + 1];
        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        DFS(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<= n ; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int v) {
        if (v > n) {
            return;
        } else {
            ch[v] = true;
            for (Integer nx : graph.get(v)) {
                if (!ch[nx]) {
                    ch[nx] = true;
                    DFS(nx);
                    arr[nx] = v;
                }
            }
        }
    }
}
