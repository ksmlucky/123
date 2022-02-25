// 14696번 딱지놀이
// https://www.acmicpc.net/problem/14696

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14696_딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int A[] = new int[5];
            int B[] = new int[5];

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                A[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                B[Integer.parseInt(st.nextToken())]++;
            }

            if (A[4] < B[4]) {
                System.out.println("B");
            } else if (A[4] > B[4]) {
                System.out.println("A");
            } else if (A[3] < B[3]) {
                System.out.println("B");
            } else if (A[3] > B[3]) {
                System.out.println("A");
            } else if (A[2] < B[2]) {
                System.out.println("B");
            } else if (A[2] > B[2]) {
                System.out.println("A");
            } else if (A[1] < B[1]) {
                System.out.println("B");
            } else if (A[1] > B[1]) {
                System.out.println("A");
            } else {
                System.out.println("D");
            }
        }
    }
}
