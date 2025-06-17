package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _2644 {
    static int n, start, target, m ,ans;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1.그래프 만들기
        ans = -1;
        n = sc.nextInt();
        start = sc.nextInt();
        target = sc.nextInt();
        m = sc.nextInt();
        ch = new boolean[n + 10];
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i <=n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //DFS 호출 및 출력
        DFS(start, 0);
        System.out.println(ans);
    }
    static void DFS(int v, int L){
        if (v == target){
            ans = L;
            return;
        }else{
            ch[v] = true;
            for (Integer nx: graph.get(v)) {
                if(!ch[nx]){
                    DFS(nx, L + 1);
                    if (ans != -1){
                        return;
                    }
                }
            }
        }
    }

}
