package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursive_1 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        DFS(n);
        for(int i = list.size()-1 ; i >= 0; i --){
            System.out.print(list.get(i));
        }
    }
    static void DFS(int v){
        if (v == 0){
            return;
        }else{
            list.add(v % 2);
            DFS(v / 2);
        }
    }
}