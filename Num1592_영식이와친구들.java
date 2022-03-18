// 1592번 - 영식이와 친구들
// https://www.acmicpc.net/problem/1592

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1592_영식이와친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int count = 0; // 게임에서 총 몇번 공을 던지는지
        arr[0] = 1; // 처음 공을 받는 1번 친구도 받는거로 count
        int ball = 0; // 공이 누구한테 있는지 알기 위한 인덱스
        boolean isGameOver = false; // 기임 종료 조건 체크 플래그
        boolean flag = false; // while문 탈출하기 위한 플래그
        while (!isGameOver) {
            // M이 1이면 바로 게임 종료가 되야하므로 탈출 조건을 제일 먼저
            for (int i = 0; i < N; i++) {
                if (arr[i] == M) { // 공을 M번 받은 사람이 있으면 게임 종료
                    isGameOver = true;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            if (arr[ball] % 2 == 0) { // 0부터 시작이므로 홀수 짝수 반대로
                ball = (ball + L) % N; // 홀수면 시계 방향으로
            } else {
                ball = (ball + (N - L)) % N; // 짝수면 반시계 방향으로
            }
            arr[ball]++;
            count++;
        }

        System.out.println(count);
    }
}
