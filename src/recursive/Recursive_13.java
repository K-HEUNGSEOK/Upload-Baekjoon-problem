package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_13 {
    static int n , m ;
    static int[] arr;
    static int[] param;
    static boolean[] ch;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new boolean[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        param = new int[m];
        DFS(0);
    }
    static void DFS(int v){

        if (v == m){
            for(int i = 0 ; i < m ; i ++){
                System.out.print(param[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = 0 ; i < n ; i ++){
                if (!ch[i]){
                    ch[i] = true;
                    param[v] = arr[i];
                    DFS(v + 1);
                    ch[i] = false;
                }
            }
        }

    }
}