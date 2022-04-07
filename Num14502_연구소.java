// 14502번 연구소
// https://www.acmicpc.net/problem/14502

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14502_연구소 {
    static int N, M;
    static int[][] map;
    static int[][] tempMap; // map 임시 저장 배열
    static boolean[][] visited; // 방문 체크 배열
    static int max = Integer.MIN_VALUE; // 정답(안전 영역의 개수 최대값)

    // 사방 탐색(우하좌상)
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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        System.out.println(max);
    }

    // 2차원 배열 깊은 복사를 위한 함수
    private static int[][] copy(int [][] arr) {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    // 안전 영역의 개수 세는 함수
    private static int countSafeArea() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // 벽 세우고 벽이 3개가 되면 dfsLoop() 실행
    private static void makeWall(int wallCount) {
        // 벽을 3개 세웠으면 dfsLoop() 실행
        if (wallCount == 3) {
            dfsLoop();
            max = Math.max(max, countSafeArea()); // 안전영역의 최대값 갱신
            map = copy(tempMap); // map을 벽이 2개인 경우(방금 세운 벽을 세우기 전 단계)로 되돌림
            visited = new boolean[N][M]; // 다음 dfs를 위한 방문배열 초기화
            return;
        }

        // 벽 세우기(조합)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸인 경우
                    map[i][j] = 1; // 벽 세우기
                    tempMap = copy(map); // 벽이 3개이기 전의 경우를 저장
                    makeWall(wallCount + 1);
                    map[i][j] = 0; // 다음 경우의 수를 위해 복구
                }
            }
        }
    }

    // dfs 루프 돌리는 함수(바이러스를 퍼뜨리는 함수)
    private static void dfsLoop() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }


    }

    // dfs 함수(바이러스 퍼뜨리기)
    private static void dfs(int r,int c) {
        if (visited[r][c]) {
            return;
        }

        map[r][c] = 2;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            if (map[nr][nc] == 0 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
