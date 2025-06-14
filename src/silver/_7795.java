package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _7795 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int z = 0 ; z < T ; z ++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] a = new int[n];
            int ans = 0;
            for(int i = 0 ; i < n ; i ++){
                a[i] = sc.nextInt();
            }
            int [] b = new int[m];
            for(int i = 0 ; i < m ; i ++){
                b[i] = sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int lt1 = 0;
            int rt1 = n;

            while (rt1 > lt1){
                for(int j = 0 ; j < m; j ++){
                    if (a[lt1] > b[j]){
                        ans ++;
                    }else {
                        break;
                    }
                }
                lt1 ++;
            }
            System.out.println(ans);
        }
    }
}