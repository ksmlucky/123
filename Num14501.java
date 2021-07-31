// 14501번 퇴사
// https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14501 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N + 6];
        P = new int[N + 6];
        dp = new int[N + 6];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], max);   // 하루가 지날 때마다 dp배열 갱신

            dp[i + T[i]] = Math.max(dp[i + T[i]], P[i] + dp[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(dp[N + 1]);

    }
}
