package silver.queue_stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _1158 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(int i = 1 ; i <= n ; i ++){
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            int temp = k-1;
            while (temp -- > 0){
                Integer poll = queue.poll();
                queue.offer(poll);
            }
            list.add(queue.poll());
        }
        System.out.print("<");
        for(int i = 0 ; i < list.size(); i ++){
            if (i < list.size()-1){
                System.out.print(list.get(i) + ", ");
            }else{
                System.out.print(list.get(i) + ">");
            }
        }

    }
}
