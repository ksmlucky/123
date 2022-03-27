// 2667번 단지번호붙이기
// https://www.acmicpc.net/problem/2667

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num2667_단지번호붙이기 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int AptCount = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 테스트
//        for (int t = 0; t < N; t++) {
//            System.out.println(Arrays.toString(map[t]));
//        }
//        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    solution(i, j);
                    AptCount++;
                }
            }
        }

        int[] answerArr = answerCount();

        Arrays.sort(answerArr);

        StringBuilder sb = new StringBuilder();
        sb.append(AptCount).append("\n");
        for (int i = 0; i < answerArr.length; i++) {
            sb.append(answerArr[i]).append("\n");
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void solution(int i, int j) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        map[i][j] = AptCount + 1;

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }

            if (map[nr][nc] == 1 && !visited[nr][nc]) {
                solution(nr, nc);
            }
        }
    }

    private static int[] answerCount() {
        int[] tempArr = new int[AptCount];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    tempArr[map[i][j] - 1]++;
                }
            }
        }

        return tempArr;
    }
}
