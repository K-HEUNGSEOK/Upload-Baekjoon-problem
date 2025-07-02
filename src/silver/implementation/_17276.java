package silver.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _17276 {
    static int n;
    static int[][] arr;
    static int[][] copyArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T -- > 0) {
            n = sc.nextInt();
            int d = sc.nextInt();
            boolean check = true; //true면 양수 false 면 음수
            if (d < 0){
                d *= -1;
                check = false;
            }
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < d / 45; i ++){
                if (check){
                    positiveStart();
                }else{
                    negativeStart();
                }
            }
            print();
        }

    }
    static void positiveStart(){
        //0. 회전하는 배열은 계속 초기화
        copyArr = new int[n][n];
        //1. 주 대각선을 가운데 열로 옮김
        first();
        //2. 가운데 열을 부 대각선으로 옮겨야함
        second();
        //3. 부 대각선을 가운데 행으로 옮기자
        third();
        //4. x의 가운데를 주 대각선으로 옮긴다.
        four();
        //5. 최종 배열을 세팅한다.
        changeArray();
    }

    static void negativeStart(){
        copyArr = new int[n][n];
        negativeFirst();
        negativeSecond();
        negativeThird();
        negativeFour();
        changeArray();
    }

    static void changeArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyArr[i][j] == 0) {
                    copyArr[i][j] = arr[i][j];
                }
            }
        }

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = copyArr[i][j];
            }
        }
    }

    static void first() {
        //n + 1 / 2 열
        for (int i = 0; i < n; i++) {
            copyArr[i][n / 2] = arr[i][i];
        }
    }
    static void negativeFirst(){
        for(int i = 0 ; i < n ; i ++){
            copyArr[n/2][i] =  arr[i][i];
        }
    }

    static void second() {
        for (int i = 0; i < n; i++) {
            copyArr[i][n - 1 - i] = arr[i][n / 2];
        }
    }

    static void negativeSecond(){
        for(int i = 0 ; i < n ; i ++){
           copyArr[i][n/2] = arr[i][n-1-i];
        }
    }

    static void third() {
        for (int i = 0; i < n; i++) {
            copyArr[n / 2][n - i - 1] = arr[i][n - 1 - i];
        }
    }
    static void negativeThird(){
        for(int i = 0; i < n ; i ++){
            copyArr[n-1-i][i] = arr[n/2][i];
        }
    }

    static void four() {
        for (int i = 0; i < n; i++) {
            copyArr[i][i] = arr[n / 2][i];
        }
    }
    static void negativeFour(){
        for(int i = 0 ; i < n ; i ++){
            copyArr[i][i] = arr[i][n/2];
        }
    }


    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
