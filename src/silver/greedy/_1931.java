package silver.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1931 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<MeetingRoom> list = new ArrayList<>();
        for(int i = 0; i < n ; i ++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new MeetingRoom(s,e));
        }
        Collections.sort(list);
        int cnt = 1;
        int max = list.get(0).end;
        for(int i = 1 ; i < n ; i ++){
            if (max <= list.get(i).start){
                max = list.get(i).end;
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
    static class MeetingRoom implements Comparable<MeetingRoom> {
        int start, end;

        public MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(MeetingRoom o){
            if (this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
