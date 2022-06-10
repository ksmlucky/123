// 14888번 연산자 끼워 넣기
// https://www.acmicpc.net/problem/14888

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14888_연산자끼워넣기 {
    static int N;
    static int[] arr; // 입력받는 숫자 저장 배열
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operators = new int[4]; // +, -, *, /

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) { // 각각의 연산자마다 개수 추가
            operators[i] += Integer.parseInt(st.nextToken());
        }

        solution(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solution(int n, int index) {
        if (index == N) { // 모든 숫자 다 한 경우 최대/최소값 최신화
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 사용한 연산자 개수 하나 줄여주기

                if (i == 0) {
                    solution(n + arr[index], index + 1);
                } else if (i == 1) {
                    solution(n - arr[index], index + 1);
                } else if (i == 2) {
                    solution(n * arr[index], index + 1);
                } else if (i == 3) {
                    solution(n / arr[index], index + 1);
                }

                operators[i]++; // 사용했던 연산자 개수 돌려놓기
            }
        }
    }
}
