// 2468번 안전 영역
// https://www.acmicpc.net/problem/2468

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2468_안전영역 {
    static int[][] map;
    static int[][] tempMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int answerMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        tempMap = new int[N][N];

        int max = Integer.MIN_VALUE;

        // 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tempMap[i][j] = map[i][j];
                // map 안에서 가장 높은 값을 저장
                max = Math.max(max, tempMap[i][j]);
            }
        }

        // 솔루션 함수 실행마다 안전한 구역이 몇개나 있는지 카운트할 변수
        int answer = 0;

        for (int a = 0; a < max; a++) {
            // a이하면 물에 잠김
            rain(a);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 물에 잠기지 않았거나 방문하지 않은 칸이라면 솔루션 함수 실행
                    if (tempMap[i][j] != 0 && tempMap[i][j] != -1) {
                        solution(i, j);
                        // 솔루션 함수를 실행했다는 것은 안전한 구역하나를 처리했다는 뜻이므로 answer 증가
                        answer++;
                    }
                }
            }

            answerMax = Math.max(answerMax, answer); // answer 값 중에서 가장 큰 answer가 answerMax
            answer = 0; // 최대값 갱신 후 0으로 초기화

            // tempMap 원상 복구
            resetMap();
        }

        System.out.println(answerMax);
    }

    // 물에 잠겼던 애들을 다시 원상복구해줌
    public static void resetMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
    }

    // 비가 num까지 오면 tempMap에서 num 이하인 칸은 물에 잠긴거로(0으로) 만들어줌
    public static void rain(int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempMap[i][j] <= num) {
                    tempMap[i][j] = 0;
                }
            }
        }
    }

    // 솔루션 함수
    public static void solution(int r, int c) {
        // 해당 칸이 -1이면 리턴
        if (tempMap[r][c] == -1) {
            return;
        }

        // 해당 칸을 -1(이미 방문)으로 만들어줌
        if (tempMap[r][c] != 0 && tempMap[r][c] != -1) {
            tempMap[r][c] = -1;
        }

        // dr, dc를 따라서 상하좌우 순으로 탐색
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            // 범위 밖이거나 물에 잠긴 칸이면 넘어감
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || tempMap[nr][nc] == 0) {
                continue;
            }

            // 범위 밖이거나 물에 잠기지 않은 칸이면 솔루션 함수 실행
            solution(nr, nc);
        }

    }
}
