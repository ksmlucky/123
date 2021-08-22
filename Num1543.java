// 1543번 문서 검색
// https://www.acmicpc.net/problem/1543

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String word = br.readLine();
        int count = 0;
        for (int i = 0; i < str.length() - word.length() + 1; i++) {
            if (str.substring(i, i + word.length()).equals(word)) {
                count++;

                // 포문이 끝나는 동시에 i가 1이 증가하므로 1을 빼줘야 함
                i += word.length() - 1;
            }
        }

        System.out.println(count);
    }
}
