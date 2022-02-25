// 13300번 방 배정
// https://www.acmicpc.net/problem/13300

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num13300_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int[][] arr = new int[6][2]; // 행: 1~6학년, 열: 남여
        int K = Integer.parseInt(st.nextToken()); // 한 방 최대 인원 수
        int count = 0; // 방 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 성별
            int Y = Integer.parseInt(st.nextToken()) - 1; // 학년

            arr[Y][S]++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] / K > 0) {
                    if (arr[i][j] % K == 0) {
                        count += arr[i][j] / K;
                    } else {
                        count += (arr[i][j] / K) + 1;
                    }
                } else {
                    if (arr[i][j] % K != 0) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
