package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_10 {
    static int n, total;
    static int[] arr;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        if (total % 2 == 1) {
            System.out.println("NO");
            return;
        }
        DFS(0, 0);
        System.out.println(flag ? "YES" : "NO");
    }
    static void DFS(int v, int sum){
        if (flag) return;
        if (sum > total / 2) return;
        if (v == n){
            if (sum == total/2){
                flag = true;
                return;
            }
        }else{
            DFS(v + 1, sum + arr[v]);
            DFS(v + 1 , sum);
        }
    }
}