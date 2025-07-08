package silver.greedy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _11047 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int money = sc.nextInt();
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }

        int[] box = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(z -> z).toArray();

        int cnt = 0;
        int ans =0;
        while (true){
            if (money <= 0){
                break;
            }
            if (money < box[cnt]){
                cnt ++;
            }
            else{
                ans += money / box[cnt];
                money = money % box[cnt];
            }
        }
        System.out.println(ans);
    }
}
