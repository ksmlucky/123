//1436번 영화감독 숌
import java.io.*;

public class Num1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(Check(N));
    }

    public static int Check(int N) {
        int num = 666;
        int count = 1;

        while(count != N) {
            num++;

            String str = Integer.toString(num);	//num을 스트링으로 형변환
            if(str.contains("666")) {	//num에 666이 포함되어 있으면 몇번째 수인지 카운트
                count++;
            }
        }

        return num;
    }
}