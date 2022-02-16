// 2527번 직사각형
// https://www.acmicpc.net/problem/2527

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2527_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            // (a1, b1), (a2, b2)가 첫번째 직사각형
            // (x1, y1), (x2, y2)가 두번째 직사각형
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 공통 부분이 없음
            if (a2 < x1 || b2 < y1 || x2 < a1 || y2 < b1) {
                sb.append("d").append("\n");

                // 점
            } else if ((a2 == x1 && b2 == y1) || (a1 == x2 && b2 == y1) || (a2 == x1 && b1 == y2) || (a1 == x2 && b1 == y2)) {
                sb.append("c").append("\n");

                // 선분
            } else if ((a2 == x1 && b2 != y1) || (a1 == x2 && b2 != y1) || (a1 != x1 && b1 == y2) || (a1 != x2 && b1 == y2)) {
                sb.append("b").append("\n");

                // 직사각형
            } else {
                sb.append("a").append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
