// 2839번 설탕 배달
// https://www.acmicpc.net/problem/2839

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int answer = 0;
        while (true) {
            if (N < 0) {
                answer = -1;
                break;
            }
            if (N % 5 == 0) {
                count += N / 5;
                answer = count;
                break;
            } else {
                N -= 3;
                count++;
            }
        }

        System.out.println(answer);
    }
}
