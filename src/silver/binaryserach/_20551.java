package silver.binaryserach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _20551 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < m ; i ++){
            int target = sc.nextInt();
            int lt = -1;
            int rt = n;
            while (lt + 1 < rt){
                int mid = (lt+rt) / 2;

                if (arr[mid] < target){ //타겟이 더 크니까 mid를 땅겨와야함
                    lt = mid;
                }else{
                    rt = mid;
                }
            }
            if (rt < n && arr[rt] == target){
                System.out.println(rt);
            }else{
                System.out.println(-1);
            }
        }
    }

}
