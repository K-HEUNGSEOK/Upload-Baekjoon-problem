package silver.dfs_bfs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {
    static int[] move = {-1,1};
    static int ans = 0;
    static int target;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        target = sc.nextInt();
        visited[n] = true;
        if (n == target) {
            System.out.println(0);
            return;
        }
        BFS(n);
        System.out.println(ans);
    }
    static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()){
            int len = queue.size();
            ans ++;
            for(int i = 0 ; i < len; i ++){
                Integer num = queue.poll();

                int[] arr = {num -1, num +1 , num * 2};
                for (int nx : arr) {
                    if (nx < 0 || nx > 100000 || visited[nx]) continue;
                    if (nx == target){
                        return;
                    }

                    visited[nx] = true;
                    queue.offer(nx);
                }
            }
        }
    }
}
