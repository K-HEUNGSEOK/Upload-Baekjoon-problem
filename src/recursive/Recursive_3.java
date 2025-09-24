package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_3 {
    static int[] param;
    static int n;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        param = new int[n + 1];

        DFS(n);
        for(int i = 1; i <= n ; i ++){
            System.out.print(param[i] +" ");
        }
    }
    static int DFS(int v){
        if (param[v] != 0) return param[v];
        if (v <= 2) return param[v] = 1;
        else{
           return param[v] = DFS(v-1) + DFS(v-2);
        }
    }

}