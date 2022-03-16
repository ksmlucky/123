// 2804번 크로스워드 만들기
// https://www.acmicpc.net/problem/2804

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2804_크로스워드만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        char[][] map = new char[str2.length()][str1.length()];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '.';
            }
        }

//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();

        int iIndex = -1;
        int jIndex = -1;

        boolean flag = false;
        for (int i = 0; i < str2.length(); i++) {
            char temp = str2.charAt(i);

            for (int j = 0; j < str1.length(); j++) {
                if (temp == str1.charAt(j)) {
                    iIndex = i;
                    jIndex = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            map[iIndex][i] = str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            map[i][jIndex] = str2.charAt(i);
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
}
