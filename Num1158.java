// 1158번 요세푸스 문제
// https://www.acmicpc.net/problem/1158

package BAEKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        int flag = 1;
        while (true) {
            if (flag == K) {
                arrayList.add(queue.poll());
                flag = 1;
            } else {
                queue.offer(queue.poll());
                flag++;
            }
            if (queue.isEmpty()) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}
