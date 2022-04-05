package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num4963_섬의개수 {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            map = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int landCount = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        solution(i, j);
                        landCount++;
                    }
                }
            }

            sb.append(landCount).append("\n");
        }

        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }

    private static void solution(int r, int c) {
        if (visited[r][c] || map[r][c] == 0) {
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                continue;
            }

            if (map[nr][nc] == 1 && !visited[nr][nc]) {
                solution(nr, nc);
            }
        }
    }
}
