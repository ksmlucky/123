// 2583번 영역 구하기
// https://www.acmicpc.net/problem/2583

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2583_영역구하기 {
    static int N, M, K;
    static int[][] map;
    static int[][] realMap;
    static int count = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        realMap = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            for (int j = b1; j < b2; j++) {
                for (int k = a1; k < a2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        int[] answerArr = new int[count];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (realMap[i][j] != 0) {
                    answerArr[(realMap[i][j] - 1)]++;
                }
            }
        }

        Arrays.sort(answerArr);

        StringBuilder sb = new StringBuilder();

        sb.append(count).append("\n");

        for (int answer : answerArr) {
            sb.append(answer).append(" ");
        }

        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }

    private static void dfs(int r, int c) {
        realMap[r][c] = count;
        map[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] == 1) {
                continue;
            }

            if (map[nr][nc] == 0) {
                dfs(nr, nc);
            }
        }
    }
}
