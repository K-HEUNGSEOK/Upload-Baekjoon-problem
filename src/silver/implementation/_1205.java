package silver.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

    public class _1205 {
        public static void main(String[] args) throws FileNotFoundException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int[] arr = new int[p];
            for(int i = 0 ; i < n ; i ++){
                arr[i] = sc.nextInt();
            }

            arr = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue).toArray();

            if (n == 0){
                System.out.println(1);
                return;
            }
            if (n == p && arr[p - 1] >= s) {
                System.out.println(-1);
                return;
            }

            int rank = 1;
            for(int i = 0 ; i < n ; i ++){
                if (s < arr[i]){
                    rank ++;
                }else{
                    break;
                }
            }
            System.out.println(rank);
        }
    }
