package Array;
public class loop {
    public static int digi(int n) {
        int sum=0;
        while(n>0) {
            sum+=n%10;
            n/=10;
        }    
        return sum;
    }

    public static void main(String[] args) {
        int n = 582109;
        int len = (int)Math.log(n)+1, new_n=0;
        for(int i=0; i<len; i++) {
            new_n+=(n%10)*10;
        }
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += digi(n);
            n/=10;
        }
        System.out.println(new_n);
    }

}