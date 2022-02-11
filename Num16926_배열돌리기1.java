// 16926번 배열 돌리기 1
// https://www.acmicpc.net/problem/16926

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16926_배열돌리기1 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            rotateMatrix(N, M, Math.min(N / 2, M / 2));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void rotateMatrix(int N, int M, int R) {
        int[][] temp = new int[N][M];
        for (int r = 0; r < R; r++) {
            // 첫번째 열 이동
            for (int i = r; i < N - r - 1; i++) {
                temp[i + 1][r] = arr[i][r];
            }
            // 첫번째 행 이동
            for (int i = r + 1; i < M - r; i++) {
                temp[r][i - 1] = arr[r][i];
            }
            // 마지막 열 이동
            for (int i = N - r - 1; i > r; i--) {
                temp[i - 1][M - r - 1] = arr[i][M - r - 1];
            }
            // 마지막 행 이동
            for (int i = r; i < M - r - 1; i++) {
                temp[N - r - 1][i + 1] = arr[N - r - 1][i];
            }
        }
        arr = temp;
    }
}
