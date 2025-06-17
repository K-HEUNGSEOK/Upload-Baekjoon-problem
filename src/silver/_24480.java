package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _24480 {
    static int n, m , s ,cnt;
    static ArrayList<Integer>[] graph;
    static int[] arr;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1.그래프 만들기
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        cnt = 1;
        graph = new ArrayList[n+10];
        ch = new boolean[n + 10];
        arr = new int[n + 10];
        for(int i = 0 ; i <=n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        //2.내림차순 정렬
        for(int i = 1; i <= n ; i ++){
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        //3.DFS 호출 및 출력
        DFS(s);
        for(int i = 1 ; i <= n ; i ++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int v){
        if (v > n){
            return;
        }else{
            ch[v] = true;
            arr[v] = cnt ++;
            for (int nx : graph[v]) {
                if (!ch[nx]){
                    ch[nx] = true;
                    DFS(nx);
                }
            }
        }
    }
}
