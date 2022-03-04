// 10431번 줄 세우기
// https://www.acmicpc.net/problem/10431

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            st.nextToken();
            for (int i = 0; i < 20; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            int count = 0;

            arrayList.add(queue.poll());

            while (true) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j) > queue.peek()) {
                            count += arrayList.size() - j;
                            arrayList.add(j, queue.poll());
                            break;
                        } else if (j == arrayList.size() - 1) {
                            arrayList.add(arrayList.size(), queue.poll());
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }

            sb.append(t).append(" ").append(count).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }
}
