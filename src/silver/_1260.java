package silver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class _1260 {
    static int n, m, target;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder s = new StringBuilder();
    static boolean[] check;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        target = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        check = new boolean[n + 1];
        DFS(target);
        System.out.println(s);
        BFS(target);

    }

    static void DFS(int v) {
        check[v] = true;
        if(v > n) return;
        else{
            s.append(v+ " ");
            for (int nx : graph.get(v)) {
                if (!check[nx]){
                    check[nx] = true;
                    DFS(nx);
                }
            }
        }
    }

    static void BFS(int v) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        boolean[] ch = new boolean[n + 1];
        ch[v] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                sb.append(current + " ");
                for (int nx : graph.get(current)) {
                    if (!ch[nx]) {
                        ch[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}