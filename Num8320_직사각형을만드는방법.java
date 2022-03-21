// 8320번 직사각형을 만드는 방법
// https://www.acmicpc.net/problem/8320

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num8320_직사각형을만드는방법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i * j <= n) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
