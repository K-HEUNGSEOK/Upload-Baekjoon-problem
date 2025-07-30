package fastcampus.review._3day;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11725 {
    static ArrayList<Integer>[] graph;
    static int n;
    static boolean[] ch;
    static int[] dist;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new ArrayList[n + 1];
        ch = new boolean[n + 1];
        dist = new int[n+1];
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        DFS(1);
        for(int i = 2; i <= n ; i ++){
            System.out.println(dist[i]);
        }
    }
    static void DFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        ch[v] = true;
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len; i ++){
                Integer num = queue.poll();
                for (int nx: graph[num]) {
                    if (!ch[nx]){
                        ch[nx] = true;
                        dist[nx] = num;
                        queue.offer(nx);
                    }
                }
            }
        }
    }
}
