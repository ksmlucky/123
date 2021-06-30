import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num13458 {

    static int N, B, C;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        System.out.println(function(arr, B, C));
    }


    public static long function(int[] arr, int b, int c){
        long result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] - B;
            result++;

            if (arr[i] > 0) {
                result += arr[i]/C;
                if (arr[i] % C != 0){
                    result++;
                }
            }
        }

        return result;
    }

}