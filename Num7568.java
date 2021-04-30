import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        Rank(N);

    }

    public static void Rank(int N) throws IOException {
        int[][] arr = new int[N][2];

        String[] sp;

        for(int i=0;i<N;i++) {
            sp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sp[0]);
            arr[i][1] = Integer.parseInt(sp[1]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++) {
            int rank=1;

            for(int j=0;j<N;j++) {
                if(i==j) {
                    continue;
                }
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]) {
                    rank++;
                }
            }

            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
}
