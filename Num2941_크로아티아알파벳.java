// 2941번 크로아티아 알파벳
// https://www.acmicpc.net/problem/2941

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();
        int count = 0;

        for (int i = 0; i < length; i++) {

            char c = str.charAt(i);

            if(c == 'c' && i < length - 1) { // 문자가 c이고 마지막 문자가 아니면
                if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if(c == 'd' && i < length - 1) { // 문자가 d이고 마지막 문자가 아니면
                if(str.charAt(i + 1) == '-') {
                    i++;
                } else if(str.charAt(i + 1) == 'z' && i < length - 2) { // dz인 경우 마지막에서 두번째 문자가 아니면
                    if(str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            } else if((c == 'l' || c == 'n') && i < length - 1) { // 문자가 l이거나 n이고 마지막 문자가 아니면
                if(str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if((c == 's' || c == 'z') && i < length - 1) { // 문자가 s이거나 z이고 마지막 문자가 아니면
                if(str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
