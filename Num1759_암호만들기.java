// 1759번 암호 만들기
// https://www.acmicpc.net/problem/1759

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1759_암호만들기 {
    static int L, C;
    static char arr[], newArr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        newArr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            newArr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(newArr);

        combination(0, 0);
    }

    static void combination(int index, int count) {
        if (count == L) {
            int v = 0;
            int cc = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    sb.append(newArr[i]);

                    if (newArr[i] == 'a' || newArr[i] == 'e' || newArr[i] == 'i' || newArr[i] == 'o' || newArr[i] == 'u') {
                        v++;
                    } else {
                        cc++;
                    }
                }
            }
            if (v >= 1 && cc >= 2) System.out.println(sb);

        }

        for (int i = index; i < C; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
