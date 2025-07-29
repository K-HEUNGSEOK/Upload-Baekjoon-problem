package fastcampus.dfs;

import java.io.IOException;
import java.util.Scanner;

public class _1182 {
    static int n , m , cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();

        DFS(0,0);
        if (m == 0){
            cnt -= 1;
        }
        System.out.println(cnt);
    }
    static void DFS(int v, int total){
        if (v >= n){
            if (total == m){
                cnt ++;
            }
        }
        else{
            DFS(v + 1, total + arr[v]);
            DFS(v + 1, total);
        }
    }
}