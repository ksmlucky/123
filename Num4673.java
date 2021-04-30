public class Num4673 {

    public static void main(String[] args) {

        //셀프넘버가 맞는지 아닌지 체크하기 위한 bool형 배열 선언
        boolean [] selfNumList = new boolean[10001];	//10000로 하니까 에러남

        //셀프넘버가 아닌 애들 true로
        for(int i = 1; i <=10000; i++) {
            if(SelfNum(i)<=10000) {
                selfNumList[SelfNum(i)] = true;
            }

        }

        //true가 아닌 애들(셀프넘버)을 출력
        for(int j=1;j<=10000;j++) {
            if(selfNumList[j] != true) {
                System.out.println(j);
            }
        }
    }

    //셀프 넘버가 아닌 애들을 구하기 위함
    public static int SelfNum(int num) {
        int sum = num;

        //1의 자릿수 부터 더해주면서 나눔
        while(num != 0) {
            sum += (num%10);
            num = num/10;
        }

        return sum;
    }
}