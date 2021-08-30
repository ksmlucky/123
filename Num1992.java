// 1934번 쿼드트리
// https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1992 {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

    // check()로 확인해서 압축가능하면 압축
    public static void solution(int x, int y, int length) {
        // 압축 가능하면 그 색깔로 압축 후 리턴
        if (check(x, y, length)) {
            sb.append(arr[x][y]);
            return;
        } else {
            // 압축이 불가능하면 사이즈를 반으로 줄여야함
            int length2 = length / 2;

            // 괄효 열기
            sb.append('(');
            // 순서대로 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
            solution(x, y, length2);
            solution(x, y + length2, length2);
            solution(x + length2, y, length2);
            solution(x + length2, y + length2, length2);
            sb.append(')');

            return;
        }
    }

    // length만큼 압축 가능한지 체크
    public static boolean check(int x, int y, int length) {
        int pixel = arr[x][y];

        // 현재 인덱스 부터 (현재 인덱스 + length)까지 같은 색깔인지 확인
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (pixel != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        solution(0, 0, N);

        System.out.println(sb);

    }
}
