// 17086번 아기상어 2
// https://www.acmicpc.net/problem/17086

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num17086 {
    static int[][] map;
    static int N, M;
    static boolean[][] visit;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    static void bfs(int x, int y) {
        for (boolean[] arr : visit) Arrays.fill(arr, false);

        Queue<int[]> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] now = q.poll();

                if (map[now[0]][now[1]] == 1) {
                    answer = Math.max(answer, cnt);

                    return;
                }

                for (int d = 0; d < 8; d++) {
                    int nx = now[0] + dx[d], ny = now[1] + dy[d];

                    if (!isRange(nx, ny) || visit[nx][ny]) continue;

                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

            cnt++;
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
