package solved.class3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _1003 {
    static Integer[][] fibo = new Integer[41][2];
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        StringBuilder sb = new StringBuilder();

        while (T--> 0){
            int n = sc.nextInt();
            fibonacci(n);
            sb.append(fibo[n][0]  + " " + fibo[n][1]).append("\n");
        }
        System.out.println(sb);
    }
    //fibo 안에다 각 n 마다 0과 1의 갯수를 넣어두면 될 것 같은데
    static Integer[] fibonacci(int n){
        if (fibo[n][0] == null || fibo[n][1] == null){
            fibo[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            fibo[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return fibo[n];
    }
}
