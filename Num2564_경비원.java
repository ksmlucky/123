// 2564번 경비원
// https://www.acmicpc.net/problem/2564

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2564_경비원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int numOfStore = Integer.parseInt(br.readLine());
        int[][] arr = new int[numOfStore][2];
        for (int i = 0; i < numOfStore; i++) {
            st = new StringTokenizer(br.readLine());

            // 상점이 위치한 방향(북남서동 - 1234)
            arr[i][0] = Integer.parseInt(st.nextToken());

            // 상점이 북쪽남쪽에 있으면 왼쪽으로부터의 거리
            // 상점이 동쪽서쪽에 있으면 위쪽으로부터의 거리
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        int[] donggeun = new int[2];
        st = new StringTokenizer(br.readLine());
        // 동근이가 위치한 방향(북남서동 - 1234)
        donggeun[0] = Integer.parseInt(st.nextToken());
        // 동근이 북쪽남쪽에 있으면 왼쪽으로부터의 거리
        // 동근이 동쪽서쪽에 있으면 위쪽으로부터의 거리
        donggeun[1] = Integer.parseInt(st.nextToken());

        int count = 0;
        if (donggeun[0] == 1) { // 동근이가 북쪽에 있을 때
            for (int i = 0; i < numOfStore; i++) {
                if (arr[i][0] == 1) {
                    count += Math.abs(arr[i][1] - donggeun[1]);
                } else if (arr[i][0] == 2) {
                    count += Math.min(Y + arr[i][1] + donggeun[1], Y + (X - arr[i][1]) + (X - donggeun[1]));
                } else if (arr[i][0] == 3) {
                    count += arr[i][1] + donggeun[1];
                } else {
                    count += (Y - arr[i][1]) + donggeun[1];
                }
            }
        } else if (donggeun[0] == 2) { // 남쪽
            for (int i = 0; i < numOfStore; i++) {
                if (arr[i][0] == 1) {
                    count += Math.min(Y + arr[i][1] + donggeun[1], Y + (X - arr[i][1]) + (X - donggeun[1]));
                } else if (arr[i][0] == 2) {
                    count += Math.abs(arr[i][1] - donggeun[1]);
                } else if (arr[i][0] == 3) {
                    count += (Y - arr[i][1]) + donggeun[1];
                } else {
                    count += (Y - arr[i][1]) + (X - donggeun[1]);
                }
            }
        } else if (donggeun[0] == 3) { // 서쪽
            for (int i = 0; i < numOfStore; i++) {
                if (arr[i][0] == 1) {
                    count += donggeun[1] + arr[i][1];
                } else if (arr[i][0] == 2) {
                    count += (Y - donggeun[1]) + arr[i][1];
                } else if (arr[i][0] == 3) {
                    count += Math.abs(arr[i][1] - donggeun[1]);
                } else {
                    count += Math.min(X + arr[i][1] + donggeun[1], X + (Y - arr[i][1]) + (Y - donggeun[1]));
                }
            }
        } else if (donggeun[0] == 4) { // 동쪽
            for (int i = 0; i < numOfStore; i++) {
                if (arr[i][0] == 1) {
                    count += donggeun[1] + (X - arr[i][1]);
                } else if (arr[i][0] == 2) {
                    count += (Y - donggeun[1]) + (X - arr[i][1]);
                } else if (arr[i][0] == 3) {
                    count += Math.min(X + arr[i][1] + donggeun[1], X + (Y - arr[i][1]) + (Y - donggeun[1]));
                } else {
                    count += Math.abs(arr[i][1] - donggeun[1]);
                }
            }
        }

        System.out.println(count);
    }
}
