package fastcampus.review._3day;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _15654 {
    static int n,m;
    static int[] arr;
    static int[] param;
    static boolean[] ch;
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
        DFS(0);
    }
    static void DFS(int v){
        if (v == m){
            for(int i = 0 ; i < m; i++){
                System.out.print(param[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = 0 ; i < n ; i ++){
                if (!ch[i]){
                    ch[i] = true;
                param[v] = arr[i];
                DFS(v + 1);
                }
            }
        }
    }
}
