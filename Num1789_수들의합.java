// 1789번 수들의 합
// https://www.acmicpc.net/problem/1789

package BAEKJOON;

import java.util.Scanner;

public class Num1789_수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextInt();

        long start = 1;
        long sum = 0;
        while (true) {
            sum += start;
            if (sum > S) {
                start--;
                break;
            } else if (sum == S) {
                break;
            }
            start++;
        }

        System.out.println(start);
    }
}
