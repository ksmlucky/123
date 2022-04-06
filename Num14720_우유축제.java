// 14720번 우유 축제
// https://www.acmicpc.net/problem/14720

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14720_우유축제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 마실 수 있는 우유의 순서를 저장한 배열
        int[] answerArr = new int[3];
        for (int i = 0; i < answerArr.length; i++) {
            answerArr[i] = i;
        }

        int index = 0; // 지금 마실 수 있는 우유가 뭔지 체크할 수 인덱스
        int count = 0; // 마실 수 있는 우유의 개수
        for (int i = 0; i < N; i++) {
            // 인덱스가 2가 넘어가면 다시 0으로 초기화
            if (index > 2) {
                index %= 3;
            }

            // 방문한 우유가게와 지금 먹을 수 있는 우유 종류가 같으면 정답 1증가
            if (arr[i] == answerArr[index]) {
                count++;
                index++;
            }
        }

        System.out.println(count);
    }
}
