package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Num1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (maxPq.size() == minPq.size()) {
                maxPq.add(temp);

                if (minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            } else {
                minPq.add(temp);

                if (maxPq.peek() > minPq.peek()) {
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }

            System.out.println(maxPq.peek());
        }
    }
}
