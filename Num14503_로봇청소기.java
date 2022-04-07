package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14503_로봇청소기 {
    static int N, M;
    static int answer = 1;
    static int level = 0;

    static int[][] map;

    // 북동남서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(r, c, dir);
        System.out.println(answer);
    }

    private static void solution(int r, int c, int dir) {

        map[r][c] = 2; // 청소 완료

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            if (map[nr][nc] == 0) {
                answer++;
                solution(nr,nc,dir);

                return;
            }
        }

        int backDir = (dir + 2) % 4;
        int br = r + dr[backDir];
        int bc = c + dc[backDir];

        if (br < 0 || br >= N || bc < 0 || bc >= M || map[br][bc] == 1) {
            return;
        } else {
            solution(br, bc, dir);
        }
    }
}
