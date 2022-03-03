// 1091번 카드 섞기
// https://www.acmicpc.net/problem/1091

package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class Num1091_카드섞기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];
        int[] card = new int[N];
        int[] temp = new int[N];
        int[] firstCard = new int[N];


        int count = 0;

        // card 초기상태
        for (int i = 0; i < N; i++) {
            card[i] = i % 3;
            firstCard[i] = i % 3;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            boolean check = true;
            for (int i = 0; i < N; i++) { // card가 P와 같은지 확인
                // 다르면 false
                if (card[i] != P[i]) {
                    check = false;
                    break;
                }
            }
            // card와 P가 다를 경우
            if (!check) {
                for (int i = 0; i < N; i++) {
                    temp[i] = card[S[i]];
                }
                // 섞은 다음 배열 복사
                card = temp.clone();
                count++;
            } else { // card가 P와 같다면 cnt 출력.
                System.out.println(count);
                break;
            }

            // 계속 섞다가 처음 카드 배열이랑 같으면(= 한바퀴돈거)
            // 정답이 나올 수 없다는 뜻이기 때문에 -1 출력
            int num = 0;
            for (int i = 0; i < N; i++) {
                if (card[i] == firstCard[i]) {
                    num++;
                }
            }
            if (num == N) {
                System.out.println(-1);
                break;
            }

        }
    }
}
