package silver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _4963 {
    static int max = 50 + 10; // w 와 h 의 최대 넓이는 50인데 여유롭게
    static int[] dx = {-1,-1,0,1,1,1,0,-1}; // 대각선 방향 정의
    static int[] dy = {0,1,1,1,0,-1,-1,-1}; // 대각선 방향 정의
    static boolean[][] map; // 그래프 담을 배열 정의
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true){
            int w = sc.nextInt(); //가로
            int h = sc.nextInt(); //세로

            int ans = 0; //정답 변수
            if (w == 0 && h == 0){ //둘다 0이면 종료 시그널
                break;
            }
            map = new boolean[max][max]; // 반복되기 때문에 배열을 새로 생성
            for(int i = 1; i <= h ; i ++){
                for(int j = 1 ; j <= w; j ++){
                    int num = sc.nextInt();
                    if (num == 1){ // 1이면 섬이기 때문에 true
                        map[i][j] = true;
                    }
                }
            }

            for(int i = 1; i<= h ; i ++){
                for(int j = 1 ; j <= w ; j ++){
                    if (map[i][j]){ //섬이 있다면 ans ++ 해주고 호출
                        ans ++;
                        DFS(i,j);
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
    static void DFS(int x, int y) {
        map[x][y] = false; //기존 섬은 삭제해야 재방문 안함
        for(int i = 0 ; i < 8; i ++){ // 8가지 방향을 봐보고 있으면 쭉 타고감
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[nx][ny]){
                map[nx][ny] = false; // 타고갈때마다 false로 변경
                DFS(nx,ny);
            }
        }
    }
}
