// 17086번 아기상어 2
// https://www.acmicpc.net/problem/17086

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Num17086_아기상어2 {
    static int N, M;
    static int[][] map;
    static int[][] answerArr;
    // 팔방 탐색 방향 벡터(위부터 시계방향)
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Shark {
        int r;
        int c;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answerArr = new int[N][M];
        Queue<Shark> queue = new LinkedList<>();
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Shark(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Shark shark = queue.poll();

            int r = shark.r;
            int c = shark.c;
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (answerArr[nr][nc] != 0 || map[nr][nc] == 1) {
                    continue;
                }
                answerArr[nr][nc] = answerArr[r][c] + 1;
                if (answerArr[nr][nc] > answer) {
                    answer = answerArr[nr][nc];
                }
                queue.add(new Shark(nr, nc));
            }
        }

        System.out.println(answer);
    }
}
