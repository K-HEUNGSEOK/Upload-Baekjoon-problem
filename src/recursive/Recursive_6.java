package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Recursive_6 {
    static int[] move = {1, -1, 5};
    static boolean[] visit = new boolean[10001];
    static int e;
    static int ans;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //현재 위치
        e = sc.nextInt(); //타겟 위치
        ans = 0; //정답
        BFS(s);
        System.out.println(ans);
    }
    static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;
        int l = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len ; i ++){
                Integer x = queue.poll();
                for(int j = 0 ; j < 3; j ++){
                    int nx = x + move[j];
                    if (nx == e){
                        ans = l;
                        return;
                    }
                    if (isRange(nx) && !visit[nx]){
                        visit[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            l ++;
        }
    }
    static boolean isRange(int v){
        return 0 <= v && v <= 10000;
    }
}