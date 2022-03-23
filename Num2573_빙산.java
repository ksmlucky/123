package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2573_빙산 {
    static int r;
    static int c;
    static int[][] map;
    static int[][] visited;
    static int[][] melt;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new int[r][c];
        melt = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        int year = 0;

        while (true) {
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (visited[i][j] == 0 && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                break;
            } else if (count >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dr[i];
            int nx = x + dc[i];

            if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                if (map[nx][ny] == 0)
                    melt[x][y]++;

                if (visited[nx][ny] == 0 && map[nx][ny] != 0)
                    dfs(nx, ny);
            }
        }
    }

    static void melting() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] -= melt[i][j];

                if (map[i][j] < 0)
                    map[i][j] = 0;

                visited[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }
}
