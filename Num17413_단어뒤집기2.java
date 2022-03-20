// 17413번 단어 뒤집기 2
// https://www.acmicpc.net/problem/17413

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean flag = false; // 태그 안에 있으면 true 밖에 있으면 false

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                flag = true;

                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(c);
            } else if (c == '>') {
                flag = false;
                sb.append(c);
            } else if (flag) {
                sb.append(c);
            } else if (!flag) {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);






//        String[] strArr = str.split(" ");
//
//        String[] answerArr = new String[strArr.length];
//
//        for (int i = 0; i < strArr.length; i++) {
//            String tempStr = strArr[i];
//            boolean isChangePossible = true;
//            Stack<Character> stack = new Stack<>();
//
//            for (int j = 0; j < tempStr.length(); j++) {
//                if (tempStr.charAt(j) == '<') {
//                    isChangePossible = false;
//                    break;
//                } else {
//                    stack.push(tempStr.charAt(j));
//                }
//            }
//
//            String newTempStr = "";
//
//            if (isChangePossible) {
//                for (int j = 0; j < tempStr.length(); j++) {
//                    newTempStr += stack.pop();
//                }
//                answerArr[i] = newTempStr;
//            } else {
//                answerArr[i] = tempStr;
//            }
//        }
//
//
//        System.out.println(Arrays.toString(answerArr));
    }
}
