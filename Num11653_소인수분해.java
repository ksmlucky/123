// 11653번 소인수분해
// https://www.acmicpc.net/problem/11653

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num11653_소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 2;
        while (N > 1) {
            if (N % count == 0) {
                System.out.println(count);
                N = N / count;
            } else {
                count++;
            }
        }
    }
}
