package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _1940 {


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        int lt = 0;
        int rt = n - 1;
        int ans = 0;
        Arrays.sort(arr);
        while (rt > lt){
            int total = arr[lt] + arr[rt];
            if (total == m){
                ans ++;
                lt ++;
                rt --;
            }

            if (total > m){
                rt --;
            }else if (total < m){
                lt ++;
            }
        }
        System.out.println(ans);
    }
}