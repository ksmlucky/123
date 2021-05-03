import java.util.Scanner;

public class Num1065 {

    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt();

        if(num>1000) {
            System.out.println("You put wrong number.");
        }
        else
        {
            System.out.print(count(num));
        }
    }

    public static int count(int num) {
        int cnt = 0;
        
        if (num < 100) {
            return num;
        }

        else {
            cnt = 99;

            for (int i = 100; i <= num; i++) {
                int a = i/100;	//100의 자리
                int b = (i/10)%10;	//10의 자리
                int c = i%10;	//1의 자리

                if ((a-b) == (b-c)) { //등차 수열 확인
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
