package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class _15655 {
    static int n, m;
    static int[] arr, output;
    static boolean[] ch;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //수열은 오름차순
        //중복되는 수열은 여러번 출력 X

        //1. 출력직전에 오름차순을 검사 N! * 검사 비용 O(n)의 시간 복잡도
        //2. 재귀를 오름차순으로만 진입할 수 있게 조건을 변경한다
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        output = new int[m];
        ch = new boolean[n];
        Arrays.sort(arr);
        DFS(0, 0);
    }
    static void DFS(int depth, int start){
        if (depth == m){
            for(int i = 0 ; i < m ; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }else{
            for(int i = start ; i < n ; i ++){
                if (!ch[i]){
                    ch[i] = true;
                    output[depth] = arr[i];
                    DFS(depth + 1, i + 1);
                    ch[i] = false;
                }
            }
        }
    }
}
