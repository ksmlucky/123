// 3109번 - 빵집
// https://www.acmicpc.net/problem/3109

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num3109_빵집 {
    static int R, C;
    static char[][] map;
    static boolean[][] check;
    // 파이프 진행 방향(오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선)
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        check = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            check[i][0] = true;
            solution(i, 0);
        }

        System.out.println(answer);
    }

    public static boolean solution(int r, int c) {
        if (c == C - 1) {
            answer++;
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }
            if (check[nr][nc]) {
                continue;
            }
            if (map[nr][nc] == 'x') {
                continue;
            }

            // 얘는 안됨
//            if (map[nr][nc] == '.') {
//                check[nr][nc] = true;
//                solution(nr, nc);
//                check[nr][nc] = false;
//            }

            // 얘 아니면
            if (map[nr][nc] == '.') {
                check[nr][nc] = true;
                if (solution(nr, nc)) {
                    return true;
                }
            }

            // 얘는 됨
//            check[nr][nc] = true;
//            if (solution(nr, nc)) {
//                return true;
//            }
        }
        return false;
    }
}