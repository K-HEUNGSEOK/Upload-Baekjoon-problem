package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursive_2 {

    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        System.out.println(DFS(n));
    }
    static int DFS(int v){
        if (v == 1){
            return 1;
        }else{
            return v * DFS(v-1);
        }
    }
}