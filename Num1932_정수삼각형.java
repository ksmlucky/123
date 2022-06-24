// 1932번 정수 삼각형
// https://www.acmicpc.net/problem/1932

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1932_정수삼각형 {
    static int n;
    static int[][] arr; // 처음 입력받은 정수 삼각형
    static int[][] answerArr; // 정답을 구하기 위한 이차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        answerArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (i >= j) { // 삼각형 모양으로 입력받기
                    arr[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    break;
                }
            }
        }

        // 정수 삼각형의 맨 밑줄은 그대로 정답 배열에 복사
        for (int i = 0; i < n; i++) {
            answerArr[n - 1][i] = arr[n - 1][i];
        }

        // 맨 밑에서 부터 더하면서 올라오기
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (n - i - 1 >= j) {
                    answerArr[n - i - 2][j] = Math.max(answerArr[n - i - 1][j] + arr[n - i - 2][j], answerArr[n - i - 1][j + 1] + arr[n - i - 2][j]);
                }
            }
        }

        // 정답 출력
        System.out.println(answerArr[0][0]);
    }
}
