// 4485번 녹색 옷 입은 애가 젤다지?
// https://www.acmicpc.net/problem/4485

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num4485_녹색옷입은애가젤다지 {
    static int N;
    static int[][] map; // 원래 도둑루피가 있는 map
    static int[][] answerArr; // 누적 최소 도둑루피 저장할 2차원 배열
    // 사방 탐색(우하좌상)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static class Point implements Comparable<Point>{
        int r;
        int c;
        int rupee; // 도둑루피

        public Point(int r, int c, int rupee) {
            this.r = r;
            this.c = c;
            this.rupee = rupee;
        }

        // 도둑루피를 기준으로 오름차순 정렬(도둑루피가 적은 애가 맨앞에 옴)
        @Override
        public int compareTo(Point o) {
            return this.rupee - o.rupee;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());

            // 0이 나오면 끝
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            answerArr = new int[N][N];

            // 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 최소값을 구하는 문제이기 때문에 최대값으로 미리 세팅해줌
            for (int i = 0; i < N; i++) {
                Arrays.fill(answerArr[i], Integer.MAX_VALUE);
            }

            // 시작점
            answerArr[0][0] = map[0][0];

            sb.append("Problem " + t + ": ").append(dijkstra());
            sb.append("\n");
            t++;
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    // 다익스트라 알고리즘
    private static int dijkstra() {
//        Queue<Point> queue = new LinkedList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // 시작점을 일단 우선순위 큐에 넣고 시작
        pq.offer(new Point(0, 0, map[0][0]));

        // 우선 순위 큐에 아무것도 없을 때까지 반복
        while (!pq.isEmpty()) {
            Point temp = pq.poll();

            // 현재 위치
            int r = temp.r;
            int c = temp.c;

            for (int i = 0; i < 4; i++) { // 사방 탐색
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위를 벗어나면 continue
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                // 이미 다음 칸의 값이 더 작거나 같은 값인 경우 continue
                if (answerArr[nr][nc] <= map[nr][nc] + answerArr[r][c]) {
                    continue;
                }

                // 다음 칸의 값이 더 크면 더 작은 값으로 갱신
                answerArr[nr][nc] = map[nr][nc] + answerArr[r][c];

                // 갱신한 칸을 우선순위 큐에 추가
                pq.offer(new Point(nr, nc, map[nr][nc]));
            }
        }

        // 모든 칸에 시작점으로 부터의 최소비용이 저장되었으므로
        // 목적지인 answerArr[N - 1][N - 1]의 값 반환
        return answerArr[N - 1][N - 1];
    }
}
