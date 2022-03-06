package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num3085_사탕게임 {
    static int N;
    static char[][] map;
    static char[][] tempMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        tempMap = new char[N][N];


        // 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                tempMap[i][j] = str.charAt(j);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int r = i;
                int c = j;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // map 밖이면
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }
                    // 인접한 애들이 같으면
                    if (map[r][c] == map[nr][nc]) {
                        continue;
                    }

                    // 인접한 애들이 다르면
                    if (map[r][c] != map[nr][nc]) {
                        // 스왑
                        char temp = tempMap[nr][nc];
                        tempMap[nr][nc] = tempMap[r][c];
                        tempMap[r][c] = temp;

                        // 먹을 수 있는 사탕 개수 세기
                        max = Math.max(max, solution());

                        // 원래대로 돌려놓기
                        temp = tempMap[nr][nc];
                        tempMap[nr][nc] = tempMap[r][c];
                        tempMap[r][c] = temp;
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int solution() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            // 행검사
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (tempMap[i][j] == tempMap[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }

            // 열검사
            count = 1;
            for (int j = 1; j < N; j++) {
                if (tempMap[j][i] == tempMap[j - 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
