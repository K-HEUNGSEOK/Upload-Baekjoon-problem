package gold.slidingwindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _20437_re {
    static int[] alphabet;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T -- > 0){
            //처음에 입력 받는 것
            char[] arr = sc.next().toCharArray();
            int k = sc.nextInt();
           solution(k,arr);
        }
        System.out.println(sb);
    }
    static void solution(int k , char[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //k가 1이면 1 출력하고 종료
        if (k == 1){
            sb.append("1 1").append("\n");
            return;
        }
        //미리 알파벳 개수를 세준다.
        alphabet = new int[26];
        for (char c : arr) {
            alphabet[c -'a'] ++;
        }
        //여기서 반복 시작
        for(int i = 0 ; i < arr.length; i ++){
            //k보다 작은 갯수의 알파벳은 건너 뛴다.
            if (alphabet[arr[i] - 'a'] < k) continue;

            //여기까지 왔으면 k개 이상 있는 것들만 있음
            int cnt = 1;
            for(int j = i + 1; j < arr.length; j ++){
                if (arr[i] == arr[j]) cnt ++;

                //k 개수가 되면?
                if (cnt == k){
                    //두 길이가 가장 짧은 것과 큰 것 체크
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }
        //구간을 만들 수 없으면 -1 을 출력
        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
            sb.append(-1).append("\n");
        }else {
            sb.append(min).append(" ").append(max).append("\n");
        }
    }
}
