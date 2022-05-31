// 16918번 봄버맨
// https://www.acmicpc.net/problem/16918

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16918_봄버맨 {

    static int R, C, N;
    static char[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    private static void bomb(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 특이사항 제외
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X')
                continue;

            // 폭발하고 나서 .로 바꿔줌
            map[nx][ny] = '.';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
            }
        }

        // 1초씩 시간 세면서
        for (int t = 1; t < N; t++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                    // 다음 차례에 터질 폭탄은 X
                    if (map[i][j] == 'O') {
                        map[i][j] = 'X';

                    // 다음 차례에 터지지 않을 폭탄은 O
                    } else if (map[i][j] == '.') {
                        map[i][j] = 'O';
                    }
                }
            }

            t++;
            if (t >= N) {
                break;
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'X') {
                        map[i][j] = '.';
                        bomb(i, j);
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 출력하기 전에 X를 O로 바꿔주기
                if (map[i][j] == 'X')
                    map[i][j] = 'O';
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
