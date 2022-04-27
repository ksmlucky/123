package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num18405_경쟁적전염 {
    static int N, K;
    static int[][] map;
    static int[][] tempMap;
    static ArrayList<Integer> arrayList;
    static int S, X, Y;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        tempMap = new int[N][N];
        arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tempMap[i][j] = map[i][j];
                if (map[i][j] != 0) {
                    arrayList.add(map[i][j]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(arrayList);

        for (int a = 0; a < S; a++) {
            for (int b = 0; b < K; b++) {
                int temp = arrayList.get(b);

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tempMap[i][j] == temp) {
                            solution(i, j);

                        }
                    }
                }

//                for (int q = 0; q < N; q++) {
//                    System.out.println(Arrays.toString(map[q]));
//                }
//                System.out.println();

                if (map[X - 1][Y - 1] != 0) {
                    System.out.println(map[X - 1][Y - 1]);
                    System.exit(0);
                }

                copyMap(map);
            }
        }



        System.out.println(map[X - 1][Y - 1]);
    }

    private static void solution(int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
                continue;
            }

            map[nr][nc] = map[r][c];
        }
    }

    private static void copyMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = arr[i][j];
            }
        }
    }
}
