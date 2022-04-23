// 7569번 토마토
// https://www.acmicpc.net/problem/7569

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num7569_토마토 {
    static int N, M, H;
    static int[][][] map;
    static boolean[][][] visited; // 방문 체크 배열
    static Queue<Tomato> queue = new LinkedList<>();

    // 상우하좌위아래
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    private static class Tomato {
        int r;
        int c;
        int h;

        public Tomato(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        visited = new boolean[N][M][H];

        // 입력
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j][h] = Integer.parseInt(st.nextToken());

                    if (map[i][j][h] == 1) { // 익은 토마토면 넣어줌 (시작점)
                        queue.offer(new Tomato(i, j, h));
                    }
                }
            }
        }


        // bfs (큐에 아무것도 없을 때까지)
        while (!queue.isEmpty()) {
            solution();
        }

        int max = 0;

        if (isFail()) { // 토마토가 다 익지 못하면 -1 출력
            System.out.println(-1);
        } else { // 토마토가 다 익으면 며칠 걸려서 다 익었는지 출력
            System.out.println(getMax(max));
        }
    }

    // bfs
    private static void solution() {
        Tomato temp = queue.poll();

        int r = temp.r;
        int c = temp.c;
        int h = temp.h;

        if (visited[r][c][h]) {
            return;
        }

        visited[r][c][h] = true; // 방문 체크

        for (int i = 0; i < 6; i++) { // 탐색
            int nr = r + dr[i];
            int nc = c + dc[i];
            int nh = h + dh[i];

            // 범위 밖으로 벗어나면 continue
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H) {
                continue;
            }

            // 이동할 수 있는 칸이면 day를 하루 증가해서 저장하고 큐에 추가해줌
            if (map[nr][nc][nh] == 0 && !visited[nr][nc][nh]) {
                map[nr][nc][nh] = map[r][c][h] + 1;
                queue.offer(new Tomato(nr, nc, nh));
            }
        }
    }

    // map에 0(익지 않은 토마토)가 있으면 return true
    private static boolean isFail() {
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j][h] == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 며칠 걸려서 토마토가 다 익었는지 알아내는 함수
    private static int getMax(int max) {
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < map[i][j][h]) {
                        max = map[i][j][h];
                    }
                }
            }
        }

        // 걸린 일수는 max에서 1 빼줘야 함
        return max - 1;
    }
}
