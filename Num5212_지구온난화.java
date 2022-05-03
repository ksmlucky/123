package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num5212_지구온난화 {
    static int R, C;
    static char[][] map;
    static char[][] resultMap;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
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

        map = new char[R][C];
        resultMap = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                resultMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    solution(i, j, 0);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (resultMap[i][j] == 'X') {
                    rowMin = Math.min(rowMin, i);
                    rowMax = Math.max(rowMax, i);
                    colMin = Math.min(colMin, j);
                    colMax = Math.max(colMax, j);
                }
            }
        }

//        // 테스트
//        for (int q = 0; q < R; q++) {
//            System.out.println(Arrays.toString(resultMap[q]));
//        }

        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {
                sb.append(resultMap[i][j]);
            }
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }

    private static void solution(int r, int c, int count) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') {
                count++;
            }
        }

        if (count >= 3) {
            resultMap[r][c] = '.';
        }
    }
}
