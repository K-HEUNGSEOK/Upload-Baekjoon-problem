package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11728 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];
        for(int i = 0 ; i < n ; i ++){
            a[i] = sc.nextLong();
        }
        for(int i = 0 ; i < m; i ++){
            b[i] = sc.nextLong();
        }
        List<Long> list = new ArrayList<>();
        //A배열
        int lt1 = 0;
        int rt1 = n-1;

        //B 배열
        int lt2 = 0;
        int rt2 = m-1;
        while (rt1 >= lt1 && rt2 >= lt2){
            if (a[lt1] > b[lt2]){
                list.add(b[lt2]);
                lt2 ++;
            }else{
                list.add(a[lt1]);
                lt1 ++;
            }
        }
        while (rt1 >= lt1){
            list.add(a[lt1]);
            lt1 ++;
        }
        while (rt2 >= lt2){
            list.add(b[lt2]);
            lt2 ++;
        }
        StringBuilder sb=  new StringBuilder();
        for (Long integer : list) {
            sb.append(integer + " ");
        }
        System.out.println(sb);
    }
}