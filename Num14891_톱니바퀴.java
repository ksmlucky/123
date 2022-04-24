// 14891번 톱니바퀴
// https://www.acmicpc.net/problem/14891

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14891_톱니바퀴 {
    static int[][] wheel = new int[4][8];
    static int K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        arr = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 몇번 톱니바퀴인지
            arr[i][1] = Integer.parseInt(st.nextToken()); // 어느 방향으로 돌릴건지
        }

        for (int i = 0; i < K; i++) {
            int realWheel = arr[i][0] - 1;
            int direction = arr[i][1];
            switch (realWheel) {

                case 0:
                    if (isRotate(wheel[realWheel][2], wheel[realWheel + 1][6])) {
                        if (isRotate(wheel[realWheel + 1][2], wheel[realWheel + 2][6])) {
                            if (isRotate(wheel[realWheel + 2][2], wheel[realWheel + 3][6])) {
                                rotate(realWheel + 1, -direction);
                                rotate(realWheel + 2, direction);
                                rotate(realWheel + 3, -direction);
                            } else {
                                rotate(realWheel + 1, -direction);
                                rotate(realWheel + 2, direction);
                            }
                        } else {
                            rotate(realWheel + 1, -direction);
                        }
                    }
                    rotate(realWheel, direction);
                    break;
                case 1:
                    if (isRotate(wheel[realWheel][2], wheel[realWheel + 1][6])) {
                        if (isRotate(wheel[realWheel + 1][2], wheel[realWheel + 2][6])) {
                            rotate(realWheel + 1, -direction);
                            rotate(realWheel + 2, direction);
                        } else {
                            rotate(realWheel + 1, -direction);
                        }
                    }
                    if (isRotate(wheel[realWheel][6], wheel[realWheel - 1][2])) {
                        rotate(realWheel - 1, -direction);
                    }
                    rotate(realWheel, direction);
                    break;
                case 2:
                    if (isRotate(wheel[realWheel][2], wheel[realWheel + 1][6])) {
                        rotate(realWheel + 1, -direction);
                    }
                    if (isRotate(wheel[realWheel][6], wheel[realWheel - 1][2])) {
                        if (isRotate(wheel[realWheel - 1][6], wheel[realWheel - 2][2])) {
                            rotate(realWheel - 1, -direction);
                            rotate(realWheel - 2, direction);
                        } else {
                            rotate(realWheel - 1, -direction);
                        }
                    }
                    rotate(realWheel, direction);
                    break;
                case 3:
                    if (isRotate(wheel[realWheel][6], wheel[realWheel - 1][2])) {
                        if (isRotate(wheel[realWheel - 1][6], wheel[realWheel - 2][2])) {
                            if (isRotate(wheel[realWheel - 2][6], wheel[realWheel - 3][2])) {
                                rotate(realWheel - 1, -direction);
                                rotate(realWheel - 2, direction);
                                rotate(realWheel - 3, -direction);
                            } else {
                                rotate(realWheel - 1, -direction);
                                rotate(realWheel - 2, direction);
                            }
                        } else {
                            rotate(realWheel - 1, -direction);
                        }
                    }
                    rotate(realWheel, direction);
                    break;
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][0] == 1) {
                answer += Math.pow(2, i);
            }
        }

        System.out.println(answer);
    }

    private static boolean isRotate(int nowWheel, int anotherWheel) {
        if (nowWheel == anotherWheel) {
            return false;
        } else {
            return true;
        }
    }

    private static void rotate(int nowWheel, int direction) {
        int temp;
        if (direction == 1) { // 시계 방향이면
            temp = wheel[nowWheel][7];
            for (int i = 7; i > 0; i--) {
                wheel[nowWheel][i] = wheel[nowWheel][i - 1];
            }
            wheel[nowWheel][0] = temp;
        } else { // 반시계 방향이면
            temp = wheel[nowWheel][0];
            for (int i = 1; i <= 7; i++) {
                wheel[nowWheel][i - 1] = wheel[nowWheel][i];
            }
            wheel[nowWheel][7] = temp;
        }
    }
}
