package silver.greedy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _11399 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cost[] costs = new Cost[n];
        for(int i = 0 ; i < n ; i ++){
            costs[i] = new Cost(i+1, sc.nextInt());
        }
        Arrays.sort(costs);

        int[] sum = new int[n];

        for(int i = 1 ; i <= n ; i ++){
            int total = 0;
            for(int j = i -1 ; j >= 0; j --){
                total += costs[j].cost;
            }
            sum[i-1] = total;
        }
        int ans = 0;
        for (int i : sum) {
            ans += i;
        }
        System.out.println(ans);
    }
    static class Cost implements Comparable<Cost>{
        int n,cost;

        public Cost(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
        @Override
        public int compareTo(Cost o){
            if (this.cost == o.cost){
                return this.n - o.n;
            }
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Cost{" +
                    "n=" + n +
                    ", cost=" + cost +
                    '}';
        }
    }
}
