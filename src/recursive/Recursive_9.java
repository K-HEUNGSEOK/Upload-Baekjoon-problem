package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Recursive_9 {
    static int n,m;
    static List<Integer>[] graph;
    static boolean[] ch;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new List[n+1];
        arr = new int[n + 1];
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }
        //1번부터 각 정점까지 가는 최소 수
        BFS(1);
        for(int i = 1; i <= n ; i ++){
            System.out.println(i + " : " + arr[i]);
        }
    }
    static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        ch = new boolean[n + 1];
        ch[v] = true;
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len ; i ++){
                Integer x = queue.poll();

                for (int nx : graph[x]) {
                    if (!ch[nx]){
                        ch[nx] = true;
                        arr[nx] = arr[x] + 1;
                        queue.offer(nx);
                    }
                }
            }
        }
    }
}