package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10709_기상캐스터 {
    static char[][] map;
    static int[][] answerMap;
    static int H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        answerMap = new int[H][W];

        // 입력
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'c') { // 구름이면
                    while (true) {
                        map[i][j] = 'f'; // 구름말고 상관없는 문자 아무거나로 만들고
                        answerMap[i][j] = count; // 정답배열에 count를 넣어줌
                        count++;

                        int nc = j + 1; // 현재칸의 오른쪽칸으로 가기 위함

                        // 다음 칸이 범위에서 벗어나거나 구름이면 count 초기화 후 break
                        if (nc >= W || map[i][nc] == 'c') {
                            count = 0;
                            break;
                        } else { // 다음 칸이 범위에 있고 구름이 아니면
                            map[i][nc] = 'f'; // 상관없는 문자 아무거나로 만들고
                            answerMap[i][nc] = count; // 정답 배열에 증가된 count 넣어주기
                            j = nc; // 현재칸을 다음칸으로 이동
                        }
                    }
                }
            }
        }

        // 마지막에 . 남은거는 -1로
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '.') {
                    answerMap[i][j] = -1;
                }
            }
        }

//        // 테스트
//        System.out.println();
//        for (int a = 0; a < H; a++) {
//            System.out.println(Arrays.toString(answerMap[a]));
//        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(answerMap[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
