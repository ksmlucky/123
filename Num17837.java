//17837번 새로운 게임 2
//https://www.acmicpc.net/problem/17837

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Num17837 {
    static int[][] pieces, map;
    static int N, K;
    static Deque<Integer>[][] piecesNumbers;
    static int[] dx = { 1, -1, 0, 0 };  //오, 왼
    static int[] dy = { 0, 0, -1, 1 };  //위, 아래


    //move 함수, 파란색에 갔다왔는지도 체크
    static boolean move(int x, int y, int direction, int index, boolean is) {
        int nextX = x + dx[direction];
        int nextY = y + dy[direction];
        Deque<Integer> tempDeque = new ArrayDeque<Integer>();
        int color;
        boolean checked = false;

        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        pieces = new int[N + 1][3]; // 1 - K 인덱스 말.  0: x, 1: y, 2: direction
        map = new int[N + 1][N + 1];
        piecesNumbers = new ArrayDeque[N + 1][N + 1];

        // 게임판 색깔
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int element = Integer.valueOf(st.nextToken());
                map[i][j] = element;
                piecesNumbers[i][j] = new ArrayDeque<Integer>();
            }
        }

        // 말 배치
        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.valueOf(st.nextToken());
            int x = Integer.valueOf(st.nextToken());
            int direction = Integer.valueOf(st.nextToken()) - 1;

            pieces[i][0] = x;
            pieces[i][1] = y;
            pieces[i][2] = direction;
            piecesNumbers[y][x].offer(i);

        }


        int time = 1;
        while(time <= 1000) {
            for(int i = 1; i <= K; i++) {
                int x = pieces[i][0];
                int y = pieces[i][1];
                int direction = pieces[i][2];

                //move함수 자리
            }
            time++;
        }
        System.out.println(-1);

    }
}
