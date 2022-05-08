// 3055번 탈출
// https://www.acmicpc.net/problem/3055

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num3055_탈출 {
    static int R, C;
    static int[][] map;
    static boolean flag = false;
    static int time = 0;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static Queue<Water> waterQueue;
    static Queue<Hedgehog> hedgehogQueue;

    private static class Water {
        int r;
        int c;

        public Water(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class Hedgehog {
        int r;
        int c;

        public Hedgehog(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        hedgehogQueue = new LinkedList<>();
        waterQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char temp = str.charAt(j);
                if (temp == 'X') { // 돌
                    map[i][j] = -2;
                } else if (temp == 'S') { // 고슴도치의 위치
                    map[i][j] = 1;
                    hedgehogQueue.offer(new Hedgehog(i, j)); // bfs를 위한 큐에 넣어주기
                } else if (temp == 'D') { // 비버의 굴의 위치
                    map[i][j] = 2;
                } else if (temp == '*') { // 물의 위치
                    map[i][j] = -1;
                    waterQueue.offer(new Water(i, j)); // bfs를 위한 큐에 넣어주기
                } else { // 고슴도치든 물이든 갈 수 있는 곳
                    map[i][j] = 0;
                }
            }
        }

        // flag가 true가 될 때(고슴도치가 2(비버의 굴)을 만날 때)까지 실행
        while (!flag) {
            // 고슴도치가 먼저 이동하면 물에 빠질 수 있으므로 물을 먼저 퍼지게 하기
            waterBfsLoop(); // 물 bfs로 퍼지게 하기
            hedgehogBfsLoop(); // 고슴도치 bfs로 다음 칸으로 이동하기
            time++; // 시간 1증가

            // 고슴도치큐에 아무것도 없다는 것은 이미 다 막혀서 움직일 곳이 없다는 뜻
            if (hedgehogQueue.isEmpty()) {
                break;
            }
        }

        if (isKAKTUS()) { // 고슴도치가 비버의 굴에 도착하지 못하는 경우면
            System.out.println("KAKTUS");
        } else { // 비버의 굴에 도착했으면
            System.out.println(time);
        }
    }

    // 고슴도치가 비버의 굴에 도착했는지 판별하는 함수
    private static boolean isKAKTUS() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 2) { // 2(비버의 굴)가 존재한다는 것은 고슴도치가 도착하지 못했다는 것
                    return true;
                }
            }
        }
        return false;
    }

    // 물큐의 크기만큼(한 턴만큼)만 bfs 실행
    private static void waterBfsLoop() {
        int waterQueueSize = waterQueue.size();
        for (int i = 0; i < waterQueueSize; i++) {
            waterBfs();
        }
    }

    // 물로 bfs
    private static void waterBfs() {
        Water currentWater = waterQueue.poll();
        int r = currentWater.r;
        int c = currentWater.c;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (map[nr][nc] == 0 || map[nr][nc] == 1) {
                map[nr][nc] = -1; // 다음 칸을 물로 바꿔줌
                waterQueue.offer(new Water(nr, nc));
            }
        }
    }

    // 고슴도치큐의 크기만큼(한 턴만큼)만 bfs 실행
    private static void hedgehogBfsLoop() {
        int hedgehogQueueSize = hedgehogQueue.size();
        for (int i = 0; i < hedgehogQueueSize; i++) {
            hedgehogBfs();
        }
    }

    // 고슴도치 bfs
    private static void hedgehogBfs() {
        Hedgehog currentHedgehog = hedgehogQueue.poll();
        int r = currentHedgehog.r;
        int c = currentHedgehog.c;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (map[nr][nc] == 2) { // 비버의 굴에 도착했으면
                map[nr][nc] = 1;
                flag = true;
            }

            if (map[nr][nc] == 0 || map[nr][nc] == 2) {
                map[nr][nc] = 1; // 다음 칸을 고슴도치로 바꿔줌
                hedgehogQueue.offer(new Hedgehog(nr, nc));
            }
        }
    }
}
