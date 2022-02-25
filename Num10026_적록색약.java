package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num10026_적록색약 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int aCount = 0; // 정상
    static int bCount = 0; // 적록색약
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

//        // 테스트
//        System.out.println(Arrays.deepToString(map));

        // 정상
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않았으면 실행
                if (!visited[i][j]) {
                    dfs(i, j);
                    aCount++; // 같은 구역이면 Count++
                }
            }
        }

        // 적록색약은 R과 G가 똑같이 보이므로 R을 G로 바꿔줌
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        // 적록색약은 어떻게 보이는지 알아봐야하기 때문에 방문 체크 배열 초기화
        visited = new boolean[N][N];

        // 적록색약
       for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    bCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(aCount).append(" ").append(bCount);

        System.out.println(sb);
    }

    public static void dfs(int r,int c) {
        // 이미 방문했으면 리턴
        if (visited[r][c]) {
            return;
        }

        // 방문 체크
        visited[r][c] = true;

        // 현재색깔
        char temp = map[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 범위 밖이면 나가리
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != temp) {
                continue;
            }

            // 다음 구역도 현재 구역 색과 같으면 dfs 실행
            if (map[nr][nc] == temp) {
                dfs(nr, nc);
            }
        }

    }
}
