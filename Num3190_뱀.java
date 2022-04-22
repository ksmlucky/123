// 3190번 뱀
// https://www.acmicpc.net/problem/3190

package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num3190_뱀 {
    static int N, K, L; // 맵의 크기, 사과의 개수, 방향 전환 횟수
    static int second = 0; // 시간 재기(게임이 몇 초에 끝나는지)
    static int dir = 0; // 방향(0, 1, 2, 3 = 우, 하, 좌, 상)
    static int[][] map; // 맵

    // 뱀이 있는 위치를 넣어줄거임. 맨 앞이 head, 맨 뒤가 tail. poll()하면 tail이 사라짐
    static Queue<Point> snakeQueue;

    // 방향 전환에 대한 정보(몇초에, 어느 방향으로 바꾸는지)
    static Queue<Direction> directionQueue;

    // 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    // snakeQueue에 들어갈 클래스(뱀이 존재하는 칸)
    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // directionQueue에 들어갈 클래스(방향 전환에 대한 정보(몇초에, 어느 방향으로 바꾸는지))
    private static class Direction {
        int time;
        char direction;

        public Direction(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        snakeQueue = new LinkedList<>();
        directionQueue = new LinkedList<>();

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()); // apple y좌표
            int x = Integer.parseInt(st.nextToken()); // apple x좌표

            map[y - 1][x - 1] = 1;    //사과
        }

        L = Integer.parseInt(br.readLine());

        // 방향 전환 정보 입력
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            directionQueue.offer(new Direction(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        map[0][0] = -1; // 뱀 출발점 세팅
        Point head = new Point(0, 0); // 뱀 머리 세팅
        snakeQueue.offer(head); // 뱀

        while (true) {
            second++; // 시간 1씩 증가

            int nr = head.r + dr[dir];
            int nc = head.c + dc[dir];

            // 벽에 부딪히거나 뱀 자신의 몸에 부딪히면 게임 끝
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == -1) {
                break;
            }

            // 사과가 아니면
            if (map[nr][nc] != 1) {
                Point tail = snakeQueue.poll(); // 몸 길이 유지
                map[tail.r][tail.c] = 0; // 뱀이 해당 칸을 벗어났다는 의미
            }

            head = new Point(nr, nc); // 뱀의 머리
            snakeQueue.offer(head); // 뱀 길이 늘리기
            map[nr][nc] = -1; // 뱀이 해당 칸에 존재한다는 의미

            if (!directionQueue.isEmpty()) { // 방향 전환이 남았으면
                if (directionQueue.peek().time == second) { // 방향 전환할 시간이면
                    changeDir(directionQueue.poll().direction); // 방향 전환
                }
            }
        }

        System.out.println(second);
    }

    // 방향 전환 함수
    public static void changeDir(char direction) {
        if (direction == 'L') { // 왼쪽으로 돌기
            dir = (dir + 3) % 4;
        } else { // 오른쪽으로 돌기
            dir = (dir + 1) % 4;
        }
    }
}
