package fastcampus.review._3day;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _15657 {
    static int n,m;
    static int[] arr;
    static int[] param;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        param = new int[m];
        ch = new boolean[n];
        for(int i = 0; i < n ; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        DFS(0,0);
        System.out.println(sb);
    }
    static void DFS(int v, int start){
        if (v == m){
            for(int i = 0 ; i < m; i++){
                sb.append(param[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i = start ; i < n ; i ++){
                param[v] = arr[i];
                DFS(v + 1,i);

            }
        }
    }
}
