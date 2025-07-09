package silver.dfs_bfs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _27971 {
    static int n, m, a, b, x,y, ans;
    static List<int[]> list = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        for(int i = 0 ; i < m ; i ++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] box = {x,y};
            list.add(box);
        }
        ans = -1;


        // a b 를 계속 생성하고
        // n 이랑 닿으면 멈추면 됨 근데 레벨을 정해야 함
        BFS();

        if (ans != -1){
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }
    }
    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0 ; i < len;  i++){
                Integer num = queue.poll();

                int[] dogs = {num + a, num + b}; //강아지 추가 갯수

                for (int dog : dogs) {
                    if (dog == n){
                        ans = level+1;
                        return;
                    }
                }

                for(int j = 0 ; j < dogs.length; j ++){
                    int dog = dogs[j];
                    //visited 를 앞에 두면 Index 예외 발생함
                    if (dog < 100001 && !visited[dog]){ //방문한 도그가 아님
                        //닫힌 구간 검사
                       boolean flag = false;
                        for (int[] ints : list) {
                            if (dog >= ints[0] && dog <= ints[1]){
                                flag = true;
                                break;
                            }
                        }
                        if (flag) continue;

                        visited[dog] = true;
                        queue.offer(dog);
                    }
                }
            }
            level ++;
        }
    }
}
