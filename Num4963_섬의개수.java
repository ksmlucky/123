// 4963번 섬의 개수
// https://www.acmicpc.net/problem/4963

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num4963_섬의개수 {
    static int W, H;
    static int[][] map;
    static boolean[][] visited; // 방문 체크 배열
    // 8방 탐색 (오른쪽 방향부터 시계 방향)
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

            // 0, 0 받으면 종료
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

            // 섬의 개수가 몇개인지 체크
            int landCount = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        solution(i, j); // 연결된 땅(섬) 체크
                        landCount++; // 섬 개수만큼 증가
                    }
                }
            }

            sb.append(landCount).append("\n");
        }

        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }

    // DFS
    private static void solution(int r, int c) {
        // 기저조건(방문했거나, 땅이 아니면 return
        if (visited[r][c] || map[r][c] == 0) {
            return;
        }

        // 방문 체크
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 범위 벗어나면
            if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                continue;
            }

            // 방문하기 전이고 땅이면 solution()
            if (map[nr][nc] == 1 && !visited[nr][nc]) {
                solution(nr, nc);
            }
        }
    }
}
