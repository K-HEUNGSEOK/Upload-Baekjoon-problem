package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Recursive_8_ {
    static int n, m , ans;
    static ArrayList<Integer> [] graph;
    static boolean[] ch;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = 0;
        graph = new ArrayList[n+1];
        ch = new boolean[n + 1];
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }

        DFS(1);
        System.out.println(ans);
    }
    static void DFS(int v){
        stack.push(v);
        ch[v] = true;
        if (v == n){
            ans ++;
            for (Integer i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
        }else{
            for (Integer nx : graph[v]) {
                if (!ch[nx]){
                    DFS(nx);
                }
            }
        }
        stack.pop();
        ch[v] = false;
    }
}