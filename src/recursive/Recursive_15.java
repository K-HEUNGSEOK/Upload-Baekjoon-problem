package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_15 {
    static int n, m;
    static int[] param;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        param = new int[m];
        ch = new int[n];
        DFS(0,0);

    }
    static void DFS(int v, int start){
        if (v == m){
            for(int i = 0 ; i < m ; i ++){
                System.out.print(param[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = start ; i < n ; i ++){
                    param[v] = i + 1;
                    DFS(v+1, i+1);
                    ch[i] = 0;
            }
        }
    }
    static int combination(int n, int r){
        if (n == r || r ==0) return 1;
        else {return combination(n-1,r-1) + combination(n-1,r);
        }
    }
}