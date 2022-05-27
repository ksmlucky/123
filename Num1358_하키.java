// 1358번 하키
// https://www.acmicpc.net/problem/1358

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1358_하키 {
    static double W, H, X, Y;
    static double radius;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Double.parseDouble(st.nextToken());
        H = Double.parseDouble(st.nextToken());
        X = Double.parseDouble(st.nextToken());
        Y = Double.parseDouble(st.nextToken());
        radius = H / 2;
        int P = Integer.parseInt(st.nextToken()); // 선수의 수

//        System.out.println("W = " + W);
//        System.out.println("H = " + H);
//        System.out.println("X = " + X);
//        System.out.println("Y = " + Y);
//        System.out.println("radius = " + radius);

        int count = 0;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (isPeople(x, y)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static double getDistancePow(double x1, double y1, double x2, double y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }

    public static boolean isPeople(int x, int y) {
        if (getDistancePow(x, y, X, Y + radius) <= Math.pow(radius, 2)) {
            return true;
        } else if (getDistancePow(x, y, X + W, Y + radius) <= Math.pow(radius, 2)) {
            return true;
        } else if (x <= X + W && x >= X && y <= y + H && y >= Y) {
            return true;
        }
        return false;
    }
}
