package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_8 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(DFS(root, 0));
    }
    static int DFS(Node root, int cnt){
        if (root.lt == null && root.rt == null){
            return cnt;
        }else {
            return Math.min(DFS(root.lt, cnt + 1), DFS(root.rt, cnt + 1));
        }
    }
    static class Node{
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }
    }
}