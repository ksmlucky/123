package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String value = st.nextToken();
                String key = st.nextToken();
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }

            if (hashMap.size() == 1) {
                for (int num : hashMap.values()) {
                    System.out.println(num);
                }
            } else {
                int answer = 1;
                for (int num : hashMap.values()) {
                    answer *= ++num;
                }
                answer--;
                System.out.println(answer);
            }
        }
    }
}
