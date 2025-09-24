package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Recursive_4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
    static void DFS(Node root){
        if (root==null) return;
        else{
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    static class Node{
        int data;
        Node lt,rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", lt=" + lt +
                    ", rt=" + rt +
                    '}';
        }
    }
}