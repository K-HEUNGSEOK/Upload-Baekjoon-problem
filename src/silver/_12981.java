package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class _12981 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int n = sc.nextInt();
        int p = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int[] dna = new int[4];
        char[] ch = {'A','C','G','T'};
        for(int i = 0 ; i < dna.length; i ++){
            dna[i] = sc.nextInt();
        }
        //A C G T 임 DNA는


        HashMap<Character,Integer> map = new HashMap<>();
        //슬라이딩 윈도우 완성
        for(int i = 0 ; i < p -1; i ++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        for(int i = p -1 ; i < n; i ++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            if (check(map,ch,dna)){
                ans ++;
            }
            if (map.get(arr[i - p + 1]) == 1){
                map.remove(arr[i - p + 1]);
            }else {
                map.put(arr[i - p + 1], map.get(arr[i - p + 1]) - 1);
            }
        }
        System.out.println(ans);
    }

    private static boolean check(HashMap<Character, Integer> map, char[] ch, int[] dna) {
        for(int i = 0 ; i < ch.length; i ++){
            if (map.getOrDefault(ch[i],0) < dna[i]){
                return false;
            }
        }
        return true;
    }
}