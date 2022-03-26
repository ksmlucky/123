// 1388번 바닥 장식
// https://www.acmicpc.net/problem/1388

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1388_바닥장식 {
    static char[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int count = 0; // 바닥 판자 개수(정답)

        // 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    solution(i, j, map[i][j]);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // DFS
    public static void solution(int r, int c, char current) { // 열, 행, 현재 판자 모양
        // 이미 방문한 칸이면 return
        if (visited[r][c]) {
            return;
        }

        // 방문했으면 true로 바꿔주기
        visited[r][c] = true;

        if (map[r][c] == '-') { // -모양이면 같은 행으로 쭉
            int nc = c + 1; // 행 방향으로 탐색

            if (nc >= M) { // 범위 벗어나면 리턴
                return;
            } else {
                // 다음으로 탐색할 칸의 판자 모양이 현재 판자와 같으면 탐색 ㄱㄱ
                if (current == map[r][nc]) {
                    solution(r, nc, map[r][nc]);
                }

            }

        } else if (map[r][c] == '|') {
            int nr = r + 1; // 열 방향으로 탐색

            if (nr >= N) { // 범위 벗어나면 리턴
                return;
            } else {
                // 다음으로 탐색할 칸의 판자 모양이 현재 판자와 같으면 탐색 ㄱㄱ
                if (current == map[nr][c]) {
                    solution(nr, c, map[nr][c]);
                }
            }

        }

    }
}
