// 1347번 미로 만들기
// https://www.acmicpc.net/problem/1347

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1347_미로만들기 {
    static int N;
    // 남서북동 - 홍준이가 처음에 남쪽을 보고 있기 때문(사실 밑에서 고쳐도 돼서 상관은 없긴함)
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // 홍준이가 적은 내용의 길이가 0보다 크고 50보다 작기 때문에 최대 map의 크기를 100으로 잡음
        char[][] map = new char[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#'; // 미리 벽으로 다 만들어 놓음
            }
        }

        int startX, startY, minY, minX, maxY, maxX;
        // 홍준이가 적은 내용의 길이가 0보다 크고 50보다 작기 때문에 시작을 (50, 50)에서 함
        startX = startY = minY = minX = maxX = maxY = 50;

        int d = 0; // 맨 처음 시작 방향(홍준이가 바라보고 있는 남쪽)

        map[startY][startX] = '.';

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == 'F') { // 앞으로 전진이면
                // 앞으로 전진하고
                startY += dr[d];
                startX += dc[d];
                map[startY][startX] = '.'; // 그 위치를 이동할 수 있는 칸이라고 표시

                // 지도의 시작점과 끝점을 최신화
                maxY = Math.max(maxY, startY);
                maxX = Math.max(maxX, startX);
                minY = Math.min(minY, startY);
                minX = Math.min(minX, startX);
            } else if (temp == 'R') { // 오른쪽이면 방향 전환
                d = (d + 1) % 4;
            } else if (temp == 'L') { // 왼쪽이면 방향 전환
                d = (d + 3) % 4;
            }
        }

        // 필요한 부분만 출력
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
