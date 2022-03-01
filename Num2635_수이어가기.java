// 2635번 수 이어가기
// https://www.acmicpc.net/problem/2635

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2635_수이어가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int count = 2;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int a = N;
            int b = i;

            while (true) {
                int temp = solution(a, b);

                if (temp >= 0) {
                    count++;
                } else {
                    break;
                }

                a = b;
                b = temp;

            }

            if (max < count) {
                max = count;
                answer = i;
            }
            count = 2;
        }

        int a = N;
        int b = answer;

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(N).append(" ").append(answer).append(" ");

        while (true) {
            int temp = solution(a, b);

            if (temp >= 0) {
                sb.append(temp).append(" ");
            }

            if (temp < 0) {
                break;
            }

            a = b;
            b = temp;
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int solution(int a, int b) {
        return a - b;
    }
}
