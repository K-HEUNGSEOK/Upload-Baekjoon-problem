package silver.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _1244 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        for(int i = 1; i <= n ; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt(); //학생 수
        for(int i = 0; i < m ; i ++){
            int g = sc.nextInt(); //성별
            int s = sc.nextInt(); //스위치 번호
            if (g == 1){
                manSwitch(s);
            }else{
                womanSwitch(s);
            }
        }
        for(int i = 1; i <= n ; i ++){
            System.out.print(arr[i] + " ");
            if (i % 20 == 0){
                System.out.println();
            }
        }
    }
    static boolean isRange(int s){
        return 1 <= s && s <= n;
    }
    static void womanSwitch(int s){
        int start = s;
        int end = s;
        while (true){
            if (!isRange(start-1) || !isRange(end+1)) break;

            if (arr[start-1] == arr[end +1]){
                start -= 1;
                end += 1;
            }else {
                break;
            }
        }
        for(int i = start ; i <= end; i ++){
            if (arr[i] == 0){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
    }

    //남자애 로직
    static void manSwitch(int s){
        for(int i = s; i <= n; i += s){

            if (arr[i] == 0){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
    }
}