// 2239번 스도쿠
// https://www.acmicpc.net/problem/2239

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num2239_스도쿠 {
    static int[][] map = new int[9][9];
    static ArrayList<int[]> arrayList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';

                // 0인 애들에 숫자를 넣어야하므로 0인 애들 arraylist에 저장
                if (map[i][j] == 0) {
                    arrayList.add(new int[]{i, j});
                }
            }
        }

        solution(0);
    }

    private static void solution(int num) {
        if (num == arrayList.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);

            System.exit(0);
        }

        int[] temp = arrayList.get(num);
        int r = temp[0];
        int c = temp[1];

        // 어떤 숫자 사용했는지 체크하는 함수
        boolean[] isPossible = new boolean[10];

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (map[r][i] != 0) {
                isPossible[map[r][i]] = true;
            }
        }
        // 맨밑에 for문 들어가기 전에 가지치기
        if (isOver(isPossible)) {
            return;
        }

        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (map[i][c] != 0) {
                isPossible[map[i][c]] = true;
            }
        }
        // 맨밑에 for문 들어가기 전에 가지치기
        if (isOver(isPossible)) {
            return;
        }

        // 네모 검사
        int tempR = r / 3 * 3;
        int tempC = c / 3 * 3;
        for (int i = tempR; i < tempR + 3; i++) {
            for (int j = tempC; j < tempC + 3; j++) {
                if (map[i][j] != 0) {
                    isPossible[map[i][j]] = true;
                }
            }
        }

        // 맨밑에 for문 들어가기 전에 가지치기
        if (isOver(isPossible)) {
            return;
        }

        // 사전식으로 앞서는 것부터 차례로 넣어줌
        for (int i = 1; i <= 9; i++) {
            if (!isPossible[i]) {
                map[r][c] = i; // 아직 사용하지 않은 숫자 넣어줌
                solution(num + 1);
                map[r][c] = 0; // 정답이 아니라 이 라인이 실행되는거니까 다시 0으로 돌려놓기
            }
        }
    }

    // 숫자가 이미 다 사용된 경우 return하기 위한 함수
    public static boolean isOver(boolean[] isPossible) {
        for (int i = 1; i < isPossible.length; i++) {
            if (!isPossible[i]) {
                return false;
            }
        }
        return true;
    }
}
