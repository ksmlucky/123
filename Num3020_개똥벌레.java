// 3020번 개똥벌레
// https://www.acmicpc.net/problem/3020

// https://moonsbeen.tistory.com/224 꼭 보기

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] answerArr = new int[H + 1];
        int[] down = new int[N / 2];
        int[] up = new int[N / 2];

        for (int i = 0; i < N; i++) {
            if (i % 2 != 0) { // 종유석이면
                up[i / 2] = Integer.parseInt(br.readLine());
            } else { // 석순이면
                down[i / 2] = Integer.parseInt(br.readLine());
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= H; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (i <= down[j]) {
                    answerArr[i]++;
                }
                if (i > H - up[j]) {
                    answerArr[i]++;
                }
            }
            if (min > answerArr[i]) {
                min = answerArr[i];
            }
        }

        int count = 0;
        for (int i = 0; i < answerArr.length; i++) {
            if (answerArr[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
