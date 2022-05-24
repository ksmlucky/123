// 1764번 듣보잡
// https://www.acmicpc.net/problem/1764

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Num1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> arrayList = new ArrayList<>();

        int count = 0;

        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        for (int j = 0; j < M; j++) {
            String str = br.readLine();
            if (hashSet.contains(str)) {
                count++;
                arrayList.add(str);
            }
        }

        Collections.sort(arrayList);

        System.out.println(count);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
