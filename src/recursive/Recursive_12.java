package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Recursive_12 {
    static int n , target, ans;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = Integer.MAX_VALUE;
        arr = new Integer[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        Arrays.sort(arr, (a,b) -> Integer.compare(b,a));
        target = sc.nextInt();
        DFS(0,0,0);
        System.out.println(ans);
    }
    static void DFS(int v, int total,int cnt){
        if (total > target) return;
        if (cnt >= ans) return;
        if (total == target){
            ans = Math.min(ans, cnt);
            return;
        }else{
            for(int i = 0 ; i < n ; i ++){
                DFS(v + 1, total + arr[i], cnt + 1);
            }
        }
    }
}