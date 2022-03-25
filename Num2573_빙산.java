// 2573번 빙산
// https://www.acmicpc.net/problem/2573

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2573_빙산 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    // 사방 탐색을 위한 방향 벡터(우하좌상)
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int time = 0;

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



        while (true) {
            // 테스트
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            // 빙산이 분리되지 않고 다 녹으면 끝! -> 0출력
            if (isOver()) {
                System.out.println(0);
                System.exit(0);
            }

            // 빙산이 분리되면 break
            if (solutionLoop() > 1) {
                break;
            }

            // 빙산 녹이기 함수 실행
            melt();

            // 방문 여부 체크 배열 초기화
            visited = new boolean[N][M];

            // 한 바퀴 돌 때마다 시간 증가
            time++;
        }

        System.out.println(time);
    }

    // solution()을 2차원 배열만큼 돌리는 함수
    private static int solutionLoop() {
        int iceCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    solution(i, j);
                    iceCount++;
                }
            }
        }

        return iceCount;
    }

    // 빙산이 몇개의 덩어리인지 판단하는 함수
    private static void solution(int i, int j) {
        if (map[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        for (int t = 0; t < 4; t++) {
            int nr = i + dr[t];
            int nc = j + dc[t];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            solution(nr, nc);
        }
    }

    // 빙산이 분리되지 않고 다 녹으면 끝! -> 0출력
    private static boolean isOver() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void melt() {
        // 사방 탐색을 통해서 인접해있는 0의 개수를 세어서 해당하는 칸에 넣어주기 위한 2차원 배열
        int[][] meltCountArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    // 인접한 칸 사방 탐색
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        // 범위를 벗어나면 continue
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                            continue;
                        }

                        // 인접한 칸이 0이면 해당 칸의 빙산이 얼마나 녹아야되는지 카운트
                        if (map[nr][nc] == 0) {
                            meltCountArr[i][j]++;
                        }
                    }
                }
            }
        }

        // 2차원 배열 탐색하면서 빙산 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 빙산이 있는 칸은 빙산 녹이기
                if (map[i][j] != 0) {
                    map[i][j] -= meltCountArr[i][j];

                    // 녹인 빙산은 0보다 낮아질 수 없으므로 0보다 낮으면 0으로 갱신
                    if (map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
}
