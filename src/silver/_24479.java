package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _24479 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] ch;
    static int n, m, s,cnt;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        cnt = 1;
        //그래프 만들기
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new boolean[n + 10];
        answer = new int[n + 10];
        for(int i = 0 ; i <= n ; i ++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 1; i <= n; i ++){
            Collections.sort(graph.get(i));
        }

        //방문하면서 그 방문한거에 순서를 매기고 만약 방문하지 않았다면 0으로 출력한다.
        DFS(s);
        for(int i = 1; i <= n  ; i ++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int v){
        if (v>n){
            return;
        }else{
            ch[v] = true;
            answer[v] = cnt++;
            for (int num : graph.get(v)) {
                if (!ch[num]){
                    DFS(num);
                }
            }
        }
    }
}
