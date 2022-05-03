// 5212번 지구 온난화
// https://www.acmicpc.net/problem/5212

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num5212_지구온난화 {
    static int R, C;
    static char[][] map; // 처음 지도
    static char[][] resultMap; // 정답 지도
    // 사방 탐색
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    // 정답 지도를 그리는 범위를 위한 변수
    static int rowMin = Integer.MAX_VALUE;
    static int rowMax = Integer.MIN_VALUE;
    static int colMin = Integer.MAX_VALUE;
    static int colMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C]; // 처음 지도
        resultMap = new char[R][C]; // 정답 지도

        // 입력
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                resultMap[i][j] = map[i][j];
            }
        }

        // 50년 후에 물에 잠기는 애들 선별해서 물에 잠기게 함
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    solution(i, j, 0);
                }
            }
        }

        // 지도의 크기는 모든 섬을 포함하는 가장 작은 직사각형이므로 범위 체크하기 위한 변수들 최신화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (resultMap[i][j] == 'X') { // 땅이면
                    rowMin = Math.min(rowMin, i);
                    rowMax = Math.max(rowMax, i);
                    colMin = Math.min(colMin, j);
                    colMax = Math.max(colMax, j);
                }
            }
        }

        // 범위 내의 지도만 출력
        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {
                sb.append(resultMap[i][j]);
            }
            sb.append("\n");
        }

        // 출력
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    // 3면 이상이 바다면 잠기게 하는 함수
    private static void solution(int r, int c, int count) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 처음 지도 범위 밖도 바다임. 범위 밖이거나 바다인 면 몇개인지 세주기
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') {
                count++;
            }
        }

        // 3면 이상이 바다면 잠기게 하기
        if (count >= 3) {
            resultMap[r][c] = '.';
        }
    }
}
