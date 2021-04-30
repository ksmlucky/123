import java.util.*;

//2231번 분해합
public class Num2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(SelfNum(N));
    }

    public static int SelfNum(int N) {
        int result=0;

        for(int i=0;i<N;i++) {
            int num = i;
            int sum = 0;

            //각 자리수만 더해서 sum에 대입
            while(num != 0) {
                sum += (num%10);
                num = num/10;
            }

            //sum+현재의 수i가 입력된 수N과 같으면 i는 입력된 N의 생성자
            if(sum+i==N) {
                result=i;
                break;
            }
        }


        return result;
    }
}
