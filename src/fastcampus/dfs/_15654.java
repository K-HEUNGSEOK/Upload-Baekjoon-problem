package fastcampus.dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class _15654 {
    static int n , m ;
    static int[] arr, num;
    static boolean[] ch;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        num = new int[m];
        ch = new boolean[n];
        DFS(0);
    }
    static void DFS(int v){
        //Base Case
        //m개만 출력해야하기 때문에 m 개가 되면 출력하자
        if (v == m){
            for(int i = 0 ; i < m; i ++){
                System.out.print(num[i] + " ");
            }
            System.out.println();
        }else{
            //Recursive Case
            //각각 호출을 해줘야함
            for(int i = 0 ; i < n ; i ++){
                if (!ch[i]){
                    ch[i] = true;
                    num[v] = arr[i];
                    DFS(v+1);
                    ch[i] = false;
                }
            }
        }
    }
}
