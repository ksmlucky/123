import java.io.*;
import java.util.StringTokenizer;

public class Num1149 {

    final static int RED =0;
    final static int GREEN =1;
    final static int BLUE =2;

    static int [][]dp;
    static int [][]cost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        dp = new int[N][3];
        cost = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");

            cost[i][RED]=Integer.parseInt(st.nextToken());
            cost[i][GREEN]=Integer.parseInt(st.nextToken());
            cost[i][BLUE]=Integer.parseInt(st.nextToken());
        }

        dp[0][RED]=cost[0][RED];
        dp[0][GREEN]=cost[0][GREEN];
        dp[0][BLUE]=cost[0][BLUE];

        System.out.println(Math.min(Math.min(RGBStreet(N-1, RED), RGBStreet(N-1, GREEN)), RGBStreet(N-1, BLUE)));
    }

    static int RGBStreet(int N, int COLOR) {
        if(dp[N][COLOR]==0) {
            if(COLOR==RED) {
                dp[N][RED]=cost[N][RED]+Math.min(RGBStreet(N-1, GREEN), RGBStreet(N-1, BLUE));
            }
            else if(COLOR==GREEN) {
                dp[N][GREEN]=cost[N][GREEN]+Math.min(RGBStreet(N-1, RED), RGBStreet(N-1, BLUE));
            }
            else {
                dp[N][BLUE]=cost[N][BLUE]+Math.min(RGBStreet(N-1, GREEN), RGBStreet(N-1, RED));
            }
        }

        return dp[N][COLOR];
    }
}