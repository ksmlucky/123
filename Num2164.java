// 2164번 카드2
// https://www.acmicpc.net/problem/2164

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num2164 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            queue.poll();

            int i = queue.poll();
            queue.add(i);
        }

        System.out.println(queue.poll());
    }
}
