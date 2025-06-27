package silver.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _2212 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] distance = new int[n];

        for(int i = 0; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i = 0 ; i < n-1; i ++){
            distance[i] = Math.abs(arr[i] - arr[i+1]);
        }

        int[] result = Arrays.stream(distance).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int sum = 0;
        for(int i = k-1 ; i < n ; i ++){
            sum += result[i];
        }
        System.out.println(sum);
    }
}
