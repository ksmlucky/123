// 2304번 창고 다각형
// https://www.acmicpc.net/problem/2304

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class gidoong implements Comparable<gidoong> {
    int x;
    int h;

    public gidoong(int x, int h) {
        this.x = x;
        this.h = h;
    }

    @Override
    public int compareTo(gidoong o) {
        return this.x - o.x;
    }
}

public class Num2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        gidoong[] gidoongs = new gidoong[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gidoongs[i] = new gidoong(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(gidoongs);

        // 테스트
//        for (int i = 0; i < gidoongs.length; i++) {
//            System.out.println(gidoongs[i].x + " " + gidoongs[i].h);
//        }

        int sum = 0; // 넓이
        int max = 0;

        // 왼쪽부터 가장 큰 기둥 전까지의 넓이
        int tempX = gidoongs[0].x;
        int tempH = gidoongs[0].h;
        for (int i = 1; i < gidoongs.length; i++) {
            if (tempH - gidoongs[i].h < 0) {
                sum += tempH * (gidoongs[i].x - tempX);
                tempX = gidoongs[i].x;
                tempH = gidoongs[i].h;
                max = i;
            }
        }

        // 오른쪽부터 가장 큰 기둥 전까지의 넓이
        tempX = gidoongs[gidoongs.length - 1].x;
        tempH = gidoongs[gidoongs.length - 1].h;
        for (int i = 0; i < gidoongs.length - max; i++) {
            if (tempH <= gidoongs[gidoongs.length - 1 - i].h ) {
                sum += (tempX - gidoongs[gidoongs.length - i - 1].x) * tempH;
                tempX = gidoongs[gidoongs.length - 1 - i].x;
                tempH = gidoongs[gidoongs.length - 1 - i].h;
            }
        }
        sum += tempH;

        System.out.println(sum);
    }
}
