// 16935번 배열 돌리기 3
// https://www.acmicpc.net/problem/16935

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16935_배열돌리기3 {

    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            N = arr.length;
            M = arr[0].length;
            switch (number) {
                case 1: {
                    // 1 - 상하반전
                    for (int i = 0; i < N / 2 + N % 2; i++) {
                        for (int j = 0; j < M; j++) {
                            int temp = arr[i][j];
                            arr[i][j] = arr[N - i - 1][j];
                            arr[N - i - 1][j] = temp;
                        }
                    }
                    break;
                }
                case 2: {
                    // 2 - 좌우반전
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M / 2 + M % 2; j++) {
                            int temp = arr[i][j];
                            arr[i][j] = arr[i][M - 1 - j];
                            arr[i][M - 1 - j] = temp;
                        }
                    }
                    break;
                }
                case 3: {
                    // 3 - 오른쪽으로 90도 회전
                    int[][] array3 = new int[M][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            int temp = arr[i][j];
                            array3[j][N - i - 1] = temp;
                        }
                    }
                    arr = array3;
                    break;
                }
                case 4: {
                    // 4 - 왼쪽으로 90도 회전
                    int[][] array4 = new int[M][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            int temp = arr[i][j];
                            array4[M - j - 1][i] = temp;
                        }
                    }
                    arr = array4;
                    break;
                }

                case 5: {
                    // 5 - 사등분 후 시계방향 회전
                    int[][] array5 = new int[N][M];
                    // 1 -> 2
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            array5[i][M / 2 + j] = arr[i][j];
                        }
                    }

                    // 2 -> 3
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = M / 2; j < M; j++) {
                            array5[N / 2 + i][j] = arr[i][j];
                        }
                    }

                    // 3 -> 4
                    for (int i = N / 2; i < N; i++) {
                        for (int j = M / 2; j < M; j++) {
                            array5[i][j - M / 2] = arr[i][j];
                        }
                    }

                    // 4 -> 1
                    for (int i = N / 2; i < N; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            array5[i - N / 2][j] = arr[i][j];
                        }
                    }
                    arr = array5;
                    break;
                }
                case 6: {
                    // 6 - 사등분 후 반시계방향 회전
                    int[][] array6 = new int[N][M];
                    // 1 -> 4
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            array6[i + N / 2][j] = arr[i][j];
                        }
                    }

                    // 2 -> 1
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = M / 2; j < M; j++) {
                            array6[i][j - M / 2] = arr[i][j];
                        }
                    }

                    // 3 -> 2
                    for (int i = N / 2; i < N; i++) {
                        for (int j = M / 2; j < M; j++) {
                            array6[i - N / 2][j] = arr[i][j];
                        }
                    }

                    // 4 -> 3
                    for (int i = N / 2; i < N; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            array6[i][j + M / 2] = arr[i][j];
                        }
                    }
                    arr = array6;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}