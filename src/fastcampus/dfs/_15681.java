package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _15681 {
    static int n, r, q;
    static List<Integer>[] graph;
    static boolean[] ch;
    static int[] sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1. 반복되지 않게 ch 배열을 만들어서 기록
        //2. 서브 트리 노드 합은 1로 초기화하고 탐색을 진행 (자기 자신 포함)
        //3. 메모제이션을 활용해서 반복되는 계산을 줄이자.
        n = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();
        ch = new boolean[n + 1];
        graph = new List[n + 1];
        sum = new int[n + 1];
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n - 1; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        sum[r] = getSum(r);

        for(int i = 0 ; i < q; i ++){
            int x = sc.nextInt();
            sb.append(sum[x]).append("\n");
        }
        System.out.println(sb);
    }
    static int getSum(int node){
        if (sum[node] != 0) return sum[node];
        ch[node] = true;
        int result = 1;
        for (int nx : graph[node]) {
            if (!ch[nx]){
                ch[nx] = true;
                result += getSum(nx);
            }
        }
        return sum[node] = result;
    }
}
