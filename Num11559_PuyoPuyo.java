package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num11559_PuyoPuyo {
    static final int W = 6;
    static final int H = 12;
    static char[][] map = new char[H][W];
    static boolean[][] visited = new boolean[H][W];
    static boolean flag = false;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        do {
            flag = false;
            solution();
            visited = new boolean[H][W];
            answer++;
        } while (flag);

        System.out.println(++answer);
    }

    private static void solution() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != '.') {
                    dfs(i, j, map[i][j], 1);
                    if (flag) {
                        down();
                        visited = new boolean[H][W];
                    }
                }
            }
        }
    }

    private static void dfs(int r, int c, char value, int depth) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        if (depth >= 4) {
            visited = new boolean[H][W];
            dfsBombs(r, c, map[r][c]);
            flag = true;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc] || map[nr][nc] != value) {
                continue;
            }

            if (map[nr][nc] == value || !visited[nr][nc]) {
                dfs(nr, nc, map[nr][nc], depth + 1);
            }
        }
    }

    private static void dfsBombs(int r, int c, char value) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        map[r][c] = '.';
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc] || map[nr][nc] != value) {
                continue;
            }

            if (map[nr][nc] == value || !visited[nr][nc]) {
                dfsBombs(nr, nc, map[nr][nc]);
            }
        }
    }

    private static void down() {
        for (int c = 0; c < W; c++) {
            int r = H - 1; // 아래행 시작
            while (r > 0) {
                if (map[r][c] == '.') { // 빈칸이면 내릴 벽돌 찾기
                    int nr = r - 1;
                    while (nr > 0 && map[nr][c] == '.') {
                        nr--;
                    }
                    map[r][c] = map[nr][c];
                    map[nr][c] = '.';
                }
                r--;
            }
        }
    }
}
