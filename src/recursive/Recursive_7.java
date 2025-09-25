package recursive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Recursive_7 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
    }
    static int BFS(Node root){
        int l = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len ; i ++){
                Node poll = queue.poll();
                if (poll.lt == null && poll.rt == null){
                    return l;
                }
                if (poll.lt != null) queue.offer(poll.lt);
                if (poll.rt != null) queue.offer(poll.rt);
            }
            l ++;
        }
        return -1;
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