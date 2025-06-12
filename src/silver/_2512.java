package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _2512 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int m = sc.nextInt();

        int total = 0;
        for (int i : arr) {
            total+=i;
        }
        if (total <= m){
            System.out.println(max);
        }else{
            int ans = 0;
            int lt = 0;
            int rt = max;
            while (rt >= lt){
                int mid = (rt + lt) / 2;
                int sum = 0;
                for(int i = 0 ; i < n ; i ++){
                    if (arr[i] > mid){
                        sum += mid;
                    }else{
                        sum+=arr[i];
                    }
                }

                if (sum <= m){
                    ans = mid;
                    lt = mid +1;
                }else{
                    rt = mid-1;
                }

            }
            System.out.println(ans);
        }

    }

}