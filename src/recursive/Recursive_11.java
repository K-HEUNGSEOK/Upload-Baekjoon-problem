package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_11 {
    static int n, m ,ans;
    static Student[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = 0;
        arr = new Student[n];
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            int time = sc.nextInt();
            arr[i] = new Student(num, time);
        }
        DFS(0,0, 0);
        System.out.println(ans);
    }
    static void DFS(int v, int total, int time){
        if (time > m) return;
        if (v == n){
            ans = Math.max(ans, total);
        }else{
            DFS(v + 1, total + arr[v].num, time + arr[v].time);
            DFS(v + 1, total, time);
        }
    }
    static class Student{
        int num, time;

        public Student(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}