// 11049번 행렬 곱셈 순서
//https://www.acmicpc.net/problem/11049

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11049 {
    static int[][] dp;
    static int[][] a;
    static int N;
    static int row, col;

    private static void dp(int start, int end) {
        for (int i = start; i < end; i++) {
            int result = dp[start][i] + dp[i + 1][end] + a[start][0] * a[i][1] * a[end][1];
            dp[start][end] = Math.min(dp[start][end], result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N][2];
        dp = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            a[i][0] = row;
            a[i][1] = col;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                dp(j, j + i);
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
