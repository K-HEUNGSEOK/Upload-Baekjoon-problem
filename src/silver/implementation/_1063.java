package silver.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1063 {
    static int[] dx = {  0,   0,  -1,  +1,  +1,     +1,     -1,     -1 };
    static int[] dy = { +1,  -1,   0,   0,  +1,     -1,     +1,     -1 };
    static int[][] grid = new int[8][8];
    static int kx,ky, sx,sy;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1. 입력하기
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        //A1 중에 A는 가로고 1은 -1 해준게 세로이다.
        kx = (king[1] - '0') -1; //세로
        ky = king[0] -'A'; //가로
        sx = (stone[1]-'0')-1;
        sy = stone[0] -'A';
        grid[(stone[1] - '0') -1][stone[0]-'A'] = 2; //돌의 위치
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n; i ++){
            String m = sc.next();
            move(kx,ky,m);
        }
        char kingx = (char) (ky +'A');
        int kingy = kx +1;
        System.out.println("" + kingx + kingy);
        char stonex = (char)(sy+'A');
        int stoney = sx + 1;
        System.out.println("" + stonex + stoney);

    }
    static void move(int x, int y, String move){
        int m = alphabet(move);
        int nx = kx + dx[m];
        int ny = ky + dy[m];
        if (isRange(nx,ny)){
            if (nx == sx && ny == sy){
                int nsx = sx + dx[m];
                int nsy = sy + dy[m];
                if (isRange(nsx,nsy)){
                    sx = nsx;
                    sy = nsy;
                    kx = nx;
                    ky = ny;
                }
            }else{
                kx = nx;
                ky = ny;
            }
        }
    }
    static int alphabet(String x){
        switch (x){
            case "R":
                return 0;
            case "L":
                return 1;
            case "B":
                return 2;
            case "T":
                return 3;
            case "RT":
                return 4;
            case "LT":
                return 5;
            case "RB":
                return 6;
            case "LB":
                return 7;

        }
        return -1;
    }
    static boolean isRange(int nx, int ny){
        return nx >= 0 && nx < 8 && ny >= 0 && ny < 8;
    }
}
