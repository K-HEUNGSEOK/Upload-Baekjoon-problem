package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_14 {
    static int[][] combiCh;
    static int[] arr;
    static int[] ch;
    static int[] combi;
    static int n,target;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        combi = new int[n];
        combiCh = new int[n][n];
        target = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        //1.조합의 수를 알아낸다.
        for(int i = 0 ; i < n; i ++){
            combi[i] = combination(n-1, i);
        }

        //2. 1~N 까지 모든 수열을 대입해본다.
        DFS(0,0);
    }
    static void DFS(int v, int sum){
        if (flag) return;
        if (v == n){
            if (sum == target){
                flag = true;
                for(int i = 0 ; i < n ; i ++){
                    System.out.print(arr[i] + " ");
                }
                return;
            }
        }else{
            for(int i = 0; i < n ; i ++){
                if (ch[i] == 0){
                    ch[i] = 1;
                    arr[v] = i + 1;
                    DFS(v + 1, sum + arr[v] * combi[v]);
                    ch[i] = 0;
                }
            }
        }
    }
    static int combination(int n, int r){
        if (combiCh[n][r] != 0) return combiCh[n][r];
        if (n == r || r == 0) return 1;
        else {
            return combiCh[n][r] = combination(n-1, r-1) + combination(n-1,r);
        }
    }
}