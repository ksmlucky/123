// 11559번 PuyoPuyo
// https://www.acmicpc.net/problem/11559

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num11559_PuyoPuyo {
    static final int W = 6;
    static final int H = 12;
    static char[][] map = new char[H][W];
    static boolean[][] visited = new boolean[H][W]; // 방문체크 배열
    static ArrayList<Point> arrayList; // 같은 색상의 인접한 뿌요가 몇개인지 세는 arraylist
    static boolean flag = false; // 게임을 끝내도 되는지 확인하는 flag
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = 0;

    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

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
            if (flag) { // 적어도 한번의 턴이 진행됐으면(뿌요가 없어졌으면)
                down(); // 내리기
                visited = new boolean[H][W];
                answer++; // 정답++
            }
        } while (flag);

        System.out.println(answer);
    }

    private static void solution() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != '.') {
                    arrayList = new ArrayList<>(); // 같은 색의 인접한 뿌요 몇개인지 세는 리스트 초기화
                    dfs(i, j, map[i][j], 1);
                    visited = new boolean[H][W];
                }
            }
        }
    }

    // 돌면서 4개 이상의 뿌요가 연결되어 있는지 검사
    private static void dfs(int r, int c, char value, int depth) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;

        // 인접한 같은 색상의 뿌요가 있으면 그 뿌요의 위치를 arrayList에 넣어줌
        arrayList.add(new Point(r, c));

        // 4개 이상의 뿌요가 연결되어 있으면 해당 색상의 뿌요 없애기
        if (arrayList.size() >= 4) {
            visited = new boolean[H][W];
            dfsBombs(r, c, map[r][c]); // 뿌요 없애기 함수
            flag = true; // 뿌요를 한번이라도 없앴다는 것은 적어도 한턴이 진행된 것!
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

    // 뿌요 없애기 함수(dfs)
    private static void dfsBombs(int r, int c, char value) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        map[r][c] = '.'; // 뿌요 없애기
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

    // 중력의 영향으로 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어뜨리는 함수
    private static void down() {
        for (int c = 0; c < W; c++) {
            int r = H - 1; // 아래행 시작
            while (r > 0) {
                if (map[r][c] == '.') { // 빈칸이면 내릴 뿌요 찾기
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
