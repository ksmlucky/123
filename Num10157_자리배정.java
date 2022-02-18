// 10157번 자리배정
// https://www.acmicpc.net/problem/10157

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10157_자리배정 {
    static int C, R, K;
    static int[][] map;
    static int count = 1;
    // 상우하좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        map = new int[R][C];

        if (K > C * R) {
            System.out.println(0);
            System.exit(0); // 말이 안되는 케이스면 시스템 종료
        }

        int r = R - 1;
        int c = 0;
        int dir = 0;

        // 얘는 다 찍는거지만
//        while (count != C * R + 1) {

        // 얘는 정답 나올때까지만 찍는거. 더 빠름. 근데 왜안빠르지
        while (count != K + 1) {
            map[r][c] = count;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 범위를 벗어났으면
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 0) {
                // 방향을 바꾸고
                dir++;
                if (dir == 4) {
                    dir = 0;
                }
                // 바꾼 방향으로 한칸가고
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
            count++;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == K) {
                    sb.append(j + 1).append(" ").append(R - i);
                    break;
                }
            }
        }

//        // 테스트
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }


        System.out.println(sb);
    }
}
