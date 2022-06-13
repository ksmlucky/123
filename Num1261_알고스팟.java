package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1261_알고스팟 {
    static int N, M;
    static int[][] map; // 원래 맵
    static int[][] answerMap; // 누적 최소 벽의 개수 저장할 2차원 배열
    // 사방 탐색(우하좌상)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static class Point implements Comparable<Point> {
        int r;
        int c;
        int weight; // 벽이 있으면 1, 없으면 0

        public Point(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        // 우선순위큐에 weight 오름차순 정렬하기 위해 구현해줘야하는 compareTo() 메서드
        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answerMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 최소값을 구해야하기 때문에 최대값으로 미리 세팅
        for (int i = 0; i < N; i++) {
            Arrays.fill(answerMap[i], Integer.MAX_VALUE);
        }
        answerMap[0][0] = map[0][0]; // 시작점은 원래 맵과 동일하게

        System.out.println(dijkstra());
    }

    // 다익스트라 알고리즘
    private static int dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // 시작점을 먼저 우선순위큐에 넣고 시작
        pq.offer(new Point(0, 0, map[0][0]));

        while(!pq.isEmpty()) {
            Point temp = pq.poll();

            // 현재 위치
            int r = temp.r;
            int c = temp.c;

            for (int d = 0; d < 4; d++) { // 사방 탐색
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 벗어나면
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                // 다음 칸의 값이 (현재 칸의 값 + 현재 칸의 누적값) 보다 이미 더 작거나 같은 값인 경우
                if (answerMap[nr][nc] <= map[r][c] + answerMap[r][c]) {
                    continue;
                }

                // 다음 칸의 값이 더 작으면 최신화
                answerMap[nr][nc] = map[r][c] + answerMap[r][c];

                // 최신화한 칸을 우선순위큐에 추가
                pq.offer(new Point(nr, nc, map[nr][nc]));
            }
        }

        return answerMap[N - 1][M - 1]; // 목적지의 값 반환
    }
}
