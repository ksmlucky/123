package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num7576_토마토_오답 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Tomato> queue = new LinkedList<>();

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static class Tomato {
        int r;
        int c;
        int day;

        public Tomato(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }

        int day = 0;

        // bfs 끝날 때까지 반복
        while (!queue.isEmpty()) {
            day = queue.peek().day; // day 갱신
            solution();
        }

//        for (int i = 0 ;i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();

        if (isFail()) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    // bfs 함수
    private static void solution() {
        Tomato temp = queue.poll();

        int r = temp.r;
        int c = temp.c;
        int day = temp.day;

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true; // 방문 체크
        map[r][c] = 1; // 익은 토마토로 만들어줌

        for (int i = 0; i < 4; i++) { // 사방 탐색
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 범위 밖이면 continue
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }

            // 다음으로 갈 수 있는 칸이면 큐에 넣어줌(day 증가시켜서)
            if (map[nr][nc] == 0 && !visited[nr][nc]) {
                queue.offer(new Tomato(nr, nc, day + 1));
            }
        }
    }

    // map에 0(익지 않은 토마토)가 있으면 return true
    private static boolean isFail() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
