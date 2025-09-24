package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_5 {
    static int n;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n + 1];
        DFS(1);
    }

    static void DFS(int v) {
        if (v > n){
            for(int i = 1; i <= n ; i ++){
                if (ch[i] != 0){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }else{
            ch[v] = 1;
            DFS(v + 1); //왼쪽 (사용한다)
            ch[v] = 0;
            DFS(v + 1); //오른쪽 (사용 안한다)

        }
    }
}