package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class _15656 {
    static int n , m ;
    static int[] arr, num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        num = new int[m];

        DFS(0,0);
        System.out.println(sb);
    }
    static void DFS(int v,int strat){
        if (v == m){
            for(int i = 0 ; i < m; i ++){
                sb.append(num[i] + " ");
            }
            sb.append("\n");
            return;
        }else{
            for(int i = strat ; i < n ; i ++){
                num[v] = arr[i];
                DFS(v+1,i);
            }
        }
    }
}
