// 14499번 주사위 굴리기
// https://www.acmicpc.net/problem/14499

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14499_주사위굴리기 {
    static int N, M, x, y, K; // 세로, 가로, 좌표x, 좌표y, 명령의 개수k
    static int[][] map;
    // 동서북남
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] dice = new int[4][3]; // 주사위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        // 1 - 동, 2 - 서, 3 - 북, 4 - 남
        for (int i = 0; i < K; i++) {
            int directionNumber = Integer.parseInt(st.nextToken());
            // 주사위를 이동시킬 수 있는지 판단
            if (moveDice(directionNumber)) { // 굴릴 수 있으면 굴리고, 굴릴 수 없으면 무시
                // 굴려서 주사위 윗면의 숫자를 출력
                System.out.println(rollDice(directionNumber));
            }
        }
    }

    // 주사위가 이동할 수 있는지 판단
    private static boolean moveDice(int number) {
        int d = number - 1;
        int tempX = x;
        int tempY = y;

        // 다음 칸의 위치
        tempX += dr[d];
        tempY += dc[d];

        if (tempX < 0 || tempX >= N || tempY < 0 || tempY >= M) { // 범위 밖이면 false 반환
            return false;
        } else { // 범위 안이면 주사위의 위치를 바꿔주고 true 반환
            x = tempX;
            y = tempY;
            // 출력
            return true;
        }
    }

    // 아래 - dice[1][1], 위 - dice[3][1]
    private static int rollDice(int number) {
        int temp;
        switch (number) { // 동서북남 방향으로 주사위 굴리기
            case 1: // 동
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 2: // 서
                temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 3: // 북
                temp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = temp;
                break;
            case 4: // 남
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                break;
        }

        // 굴린 후에 로직 수행
        if (dice[1][1] == 0) { // 주사위 밑면이 0이면 map의 숫자를 주사위 밑면에 복사
            dice[1][1] = map[x][y];
            map[x][y] = 0;
        } else if (map[x][y] == 0) { // map의 숫자가 0이면 주사위 밑면의 숫자를 map에 복사
            map[x][y] = dice[1][1];
        } else if (dice[1][1] != 0 && map[x][y] != 0) {
            // 주사위 밑면에 숫자가 있고, map의 숫자가 0이 아니면
            // 주사위 밑면의 숫자를 map의 숫자로 최신화 후 map의 숫자 0으로 만들기
            dice[1][1] = map[x][y];
            map[x][y] = 0;
        }

        // 주사위의 윗면을 반환
        return dice[3][1];
    }
}
