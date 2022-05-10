// 4179번 불!
// https://www.acmicpc.net/problem/4179

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num4179_불 {
    static int R, C;
    static int[][] map;
    // 사방탐색
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int time = 0; // 시간 재기
    static Queue<Jihoon> jihoonQueue; // 지훈이 이동 관련 큐
    static Queue<Fire> fireQueue; // 불 이동 관련 큐
    static boolean flag = false; // 무한 루프를 끝낼지 판단하는 큐

    // 지훈이 위치
    private static class Jihoon {
        int r;
        int c;

        public Jihoon(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 불 위치
    private static class Fire {
        int r;
        int c;

        public Fire(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // #(벽) - -2, .(지나갈 수 있는 공간) - 0, J(지훈이) - 1, F(불) - -1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        jihoonQueue = new LinkedList<>();
        fireQueue = new LinkedList<>();

        // 입력
        // #(벽) - -2, .(지나갈 수 있는 공간) - 0, J(지훈이) - 1, F(불) - -1
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (c == '#') {
                    map[i][j] = -2;
                } else if (c == 'F') {
                    map[i][j] = -1;
                    fireQueue.offer(new Fire(i, j)); // 불 위치 불큐에 추가
                } else if (c == '.') {
                    map[i][j] = 0;
                } else if (c == 'J') {
                    map[i][j] = 1;
                    jihoonQueue.offer(new Jihoon(i, j)); // 지훈이 위치 지훈큐에 추가
                }
            }
        }

        while (!flag) {
            // 어차피 지훈이 처음 위치는 큐에 들어가 있으므로
            // 불을 먼저 이동시켜도 상관 없음
            // 지훈이를 먼저 이동시키면 불에 잡아먹혀도 지훈이 위치가 미리 큐에 들어가기 때문에
            // 불에 먹히지 않은걸로 인식됨!
            fireBfsLoop();
            jihoonBfsLoop();
            time++;

            if (jihoonQueue.isEmpty()) { // 지훈큐가 비었다는 것은 지훈이가 이동할 수 있는 위치가 없다는 것
                break;
            }
        }

        if (flag) { // flag가 true면 지훈이가 탈출 성공
            System.out.println(time);
        } else { // flag가 false면 지훈이가 갈 곳이 없어서 while문이 break된거임
            System.out.println("IMPOSSIBLE");
        }
    }

    // fireBfs()를 돌려줌
    private static void fireBfsLoop() {
        // 현재 fireQueue의 크기만큼(바로 다음 분만큼 이동할 수 있는 만큼 큐에 들어가 있음)
        int fireQueueSize = fireQueue.size();

        for (int i = 0; i < fireQueueSize; i++) {
            fireBfs();
        }
    }

    // 불큐에 들어있는 애를 꺼내서 이동할지 말지 결정
    private static void fireBfs() {
        Fire currentFire = fireQueue.poll();
        int r = currentFire.r;
        int c = currentFire.c;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 밖이나 벽이면 continue
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -2 ) {
                continue;
            }

            // 이동할 수 있는 칸이나, 지훈이면 불질러버림
            if (map[nr][nc] == 0 || map[nr][nc] == 1) {
                map[nr][nc] = -1;
                fireQueue.offer(new Fire(nr, nc));
            }
        }
    }

    // jihoonBfs()를 돌려줌
    private static void jihoonBfsLoop() {
        // 현재 jihoonQueue의 크기만큼(바로 다음 분만큼 이동할 수 있는 만큼 큐에 들어가 있음)
        int jihoonQueueSize = jihoonQueue.size();

        for (int i = 0; i < jihoonQueueSize; i++) {
            jihoonBfs();
        }
    }

    // 지훈큐에 들어있는 애를 꺼내서 이동할지 말지 결정
    private static void jihoonBfs() {
        Jihoon currentJihoon = jihoonQueue.poll();
        int r = currentJihoon.r;
        int c = currentJihoon.c;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 밖이다? 지훈이가 탈출한거임
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                flag = true;
                return;
            }

            // 벽이면 continue
            if (map[nr][nc] == -2) {
                continue;
            }

            // 이동할 수 있는 칸이면 이동
            if (map[nr][nc] == 0) {
                map[nr][nc] = 1;
                jihoonQueue.offer(new Jihoon(nr, nc));
            }
        }
    }
}
