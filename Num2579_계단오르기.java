// 2579번 계단 오르기
// https://www.acmicpc.net/problem/2579

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        dp[2] = arr[2] + arr[1];
        dp[3] = arr[3] + Math.max(arr[1], arr[2]);

        for (int i = 4; i <= N; i++) {
            dp[i] = arr[i] + Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[N]);
    }
}
