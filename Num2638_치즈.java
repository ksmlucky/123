// 2638번 치즈
// https://www.acmicpc.net/problem/2638

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2638_치즈 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited; // 방문 체크 배열
    // 사방탐색(우하좌상)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0; // 전체 시간
        while (!isOver()) {

            solution(0, 0); // DFS
            melt(); // 녹아야하는 치즈 녹이기
            visited = new boolean[N][M]; // 방문 배열 초기화

            time++;
        }

        System.out.println(time);
    }

    // DFS
    private static void solution(int r, int c) {
        // 방문했거나 치즈가 있는 칸이면 빠져나가기
        if (visited[r][c] || map[r][c] != 0) {
            return;
        }
        visited[r][c] = true; // 방문했다고 체크하기

        // 사방 탐색하면서 방문해도되는지 판단한 후 방문하기
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            if (map[nr][nc] == 0 && !visited[nr][nc]) {
                solution(nr, nc);
            }
        }
    }

    // 치즈 녹이기 함수
    private static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    if (isMelt(i, j)) {
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    // 치즈에 공기가 닿는지 검사
    private static boolean isMelt(int r, int c) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 치즈에 공기가 닿는 부분 count
            if (visited[nr][nc]) {
                count++;
            }
        }

        // 공기에 닿는 부분이 2칸 이상이면 true
        if (count >= 2) {
            return true;
        } else {
            return false;
        }
    }

    // 다 녹았는지 검사
    private static boolean isOver() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
