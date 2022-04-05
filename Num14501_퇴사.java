// 14501번 퇴사
// https://www.acmicpc.net/problem/14501

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num14501_퇴사 {
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

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N + 1; i++) {
            // 하루가 지날 때마다 dp배열 갱신
            dp[i] = Math.max(dp[i], max);

            // 정답 배열(dp)에는 해당 날짜에 받을 수 있는 최대 이익을 저장
            dp[i + T[i]] = Math.max(dp[i + T[i]], P[i] + dp[i]);

            max = Math.max(max, dp[i]);
//            System.out.println("i = " + i);
//            System.out.println("max = " + max);
//            System.out.println(Arrays.toString(dp));
//            System.out.println();
        }

        System.out.println(dp[N + 1]);
    }
}