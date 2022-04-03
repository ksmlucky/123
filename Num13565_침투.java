// 13565번 침투
// https://www.acmicpc.net/problem/13565

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num13565_침투 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < M; i++) {
            if (map[0][i] == 0) {
                solution(0, i);
            }
        }

        for (int i = 0; i < M; i++) {
            if (map[N - 1][i] == 2) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
    }

    private static void solution(int r, int c) {
        if (visited[r][c] || map[r][c] != 0) {
            return;
        }

        visited[r][c] = true;
        map[r][c] = 2;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            if (!visited[nr][nc] && map[nr][nc] == 0) {
                solution(nr, nc);
            }
        }
    }
}
