// 1417번 국회의원 선거
// https://www.acmicpc.net/problem/1417

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1417_국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N - 1];
        int count = 0;
        int dasom = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (true) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
            }

            if (dasom <= max) {
                arr[maxIndex]--;
                dasom++;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
