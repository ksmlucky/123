// 2960번 에라토스테네스의 체
// https://www.acmicpc.net/problem/2960

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2960_에라토스테네스의체 {
    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N+1];

        int count = 0;

        for(int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = i; j <= N; j += i) {
                if (!isPrime[j]) {
                    continue;
                }
                isPrime[j] = false;
                count ++;

                if(count == K) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }
}
