// 1244번 스위치 켜고 끄기
// https://www.acmicpc.net/problem/1244

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());

        int[][] studentArr = new int[studentNum][2];
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            studentArr[i][0] = Integer.parseInt(st.nextToken());
            studentArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < studentNum; i++) {
            int sex = studentArr[i][0];
            int num = studentArr[i][1];

            // 남학생
            if (sex == 1) {
                for (int j = 0; j < N; j++) {
                    if ((j + 1) % num == 0) {
                        if (arr[j] == 0) {
                            arr[j] = 1;
                        } else {
                            arr[j] = 0;
                        }
                    }
                }

            } else { // 여학생
                if (arr[num - 1] == 0) {
                    arr[num - 1] = 1;
                } else {
                    arr[num - 1] = 0;
                }
                for (int j = 1; j < N / 2; j++) {
                    if (num - 1 + j >= N || num - 1 - j < 0) {
                        break;
                    }
                    if (arr[num - 1 - j] == arr[num - 1 + j]) {
                        if (arr[num - 1 - j] == 0) {
                            arr[num - 1 - j] = 1;
                            arr[num - 1 + j] = 1;
                        } else {
                            arr[num - 1 - j] = 0;
                            arr[num - 1 + j] = 0;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
            if ((i + 1) % 20 == 0) {
                sb.setLength(sb.length() - 1);
                sb.append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
