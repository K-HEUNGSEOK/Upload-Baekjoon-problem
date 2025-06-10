package silver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _1182 {
    static int n,s, ans;
    static int[]arr;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n+1];
        for(int i = 1; i <= n ; i ++){
            arr[i] = sc.nextInt();
        }
        DFS(1,0,0);
        System.out.println(ans);
    }
    static void DFS(int v, int sum, int cnt){
        if (v > n){
            if (sum > s){
                return;
            }
            if (sum == s && cnt > 0) ans ++;
        }else{
            DFS(v+1, sum + arr[v], cnt + 1);
            DFS(v+1 , sum, cnt );
        }
    }
}