package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class _2747 {
    static int[]arr = new int[46];
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(DFS(n));
    }
    static int DFS(int v){
        //Base Case
        //n == 1 || n == 2
        if (arr[v] != 0){
            return arr[v];
        }
        if (v == 1){
            return arr[v] = 1;
        }
        if (v == 2){
            return arr[v] = 1;
        }

        //Recursive Case
        //n = n-1 + n-2
        return arr[v] = DFS(v -1) + DFS(v - 2);
    }
}
