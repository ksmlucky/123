// 2840번 행운의 바퀴
// https://www.acmicpc.net/problem/2840

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num2840_행운의바퀴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add('0');
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            // S만큼 룰렛을 돌려줌
            for (int j = 0; j < S; j++) {
                arrayList.add(arrayList.get(0));
                arrayList.remove(0);
            }

            // 비어있는 칸이면
            if (arrayList.get(arrayList.size() - 1) == '0') {
                // 중복 체크(같은 문자가 룰렛에 2개 이상 있으면 안되니까)
                for (int j = 0; j < N; j++) {
                    if (c == arrayList.get(j)) {
                        System.out.println("!");
                        System.exit(0);
                    }
                }

                // 중복체크에 통과하면 맨뒤에 c를 넣어줌
                arrayList.remove(arrayList.size() - 1);
                arrayList.add(c);

            } else if (arrayList.get(arrayList.size() - 1) == c) { // 넣으려고 하는 칸에 넣으려고 하는 문자와 같은 문자가 있는 경우 넘어감
                continue;
            } else { // 넣으려고 하는 칸에 이미 다른 문자가 있다면 ! 출력 후 종료
                System.out.println("!");
                System.exit(0);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            // arrayList를 거꾸로 출력해줌
            if (arrayList.get(arrayList.size() - 1 - i) == '0') {
                sb.append("?");
            } else {
                sb.append(arrayList.get(arrayList.size() - 1 - i));
            }
        }

        System.out.println(sb);
    }
}
