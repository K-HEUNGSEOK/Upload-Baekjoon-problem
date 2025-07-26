package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rrewq {
    static int n, m;
    static List<Integer>[] graph;
    static int [] like; //칭찬 기록 배열
    static int [] parent; // 상사 번호기록
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //칭찬이 발생하면 모든 부하를 찾아다니기 보다
        //나에게 발생한 칭찬을 기록해두고 모든 입력을 받은뒤에 부하직원에게 한번에 뿌려준다
        n = sc.nextInt();
        m = sc.nextInt();
        like = new int[n + 1];
        parent = new int[n + 1];
        graph = new List[n + 1];
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= n ; i ++){
            parent[i] = sc.nextInt(); //부모 번호 기록
            if (parent[i] == -1) continue;
            graph[parent[i]].add(i); // 그래프의 부모번호에 자식을 등록
        }

        for(int i = 0; i < m ; i ++){
            int employee = sc.nextInt();
            int point = sc.nextInt();
            //바로바로 찾는게 아닌 미리 기록해두고 한번에 할 예정
            like[employee] += point;
        }
        //최상위 부모 1을 호출
        DFS(1);

        //마지막 출력
        for(int i =1; i<= n ; i++){
            System.out.println(like[i]);
        }
    }
    static void DFS(int node){
        for (int child : graph[node]) {
            like[child] += like[node];
            DFS(child);
        }
    }
}
