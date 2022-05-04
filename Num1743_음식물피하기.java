// 1743번 음식물 피하기
// https://www.acmicpc.net/problem/1743

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1743_음식물피하기 {
    static int N, M, K; // 세로 길이, 가로 길이, 음식물 쓰레기 개수
    static int[][] map;
    static int answer = 0; // 정답
    static int count = 0; // 음식물 쓰레기 크기를 측정하는 변수
    // 사방 탐색
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    // 빈 공간 = 0, 음식물 쓰레기 = 1, count한 음식물 쓰레기 = 2 로 두고 문제를 풀 것임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 길이
        M = Integer.parseInt(st.nextToken()); // 가로 길이
        K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수

        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            // 음식물 쓰레기의 위치를 받아서 지도(map)에 표시
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) { // 음식물이 있는 칸이면
                    dfs(i, j);
                    answer = Math.max(answer, count); // 음식물 쓰레기의 크기 중 가장 큰 애를 정답에 저장
                    count = 0;
                }
            }
        }

        // 출력
        System.out.println(answer);
    }

    // dfs 함수(음식물 쓰레기가 몇개가 이어져 있는지 측정)
    private static void dfs(int r, int c) {
        if (map[r][c] == 2) {
            return;
        }

        map[r][c] = 2; // count한 음식물 쓰레기로 바꿔줌

        count++; // 음식물 쓰레기의 크기 1증가

        // 사방 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 밖이면
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            // 다음 칸이 음식물 쓰레기면 ㄱㄱ
            if (map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}
