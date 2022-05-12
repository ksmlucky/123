// 2502번 떡 먹는 호랑이
// https://www.acmicpc.net/problem/2502

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2502_떡먹는호랑이 {
    static int D, K, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = 0;
        B = 0;

        for (int i = 1; i <= K; i++) {
            for (int j = i + 1; j <= K - 1; j++) {
                if (solution(i, j)) {
                    System.out.println(A);
                    System.out.println(B);
                    System.exit(0);
                }
            }
        }
    }

    private static boolean solution(int a, int b) {
        int[] arr = new int[31];

        arr[1] = a;
        arr[2] = b;

        for (int i = 3; i <= 30; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            if (arr[i] > K) {
                return false;
            } else if (arr[i] == K && i == D) {
                A = a;
                B = b;
                return true;
            }
        }
        return false;
    }
}
