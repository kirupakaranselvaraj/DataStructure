package Array;
import java.util.*;

class BitwiseOddEven{
public static void main(String args[]) {
Scanner sc= new Scanner(System.in);
int n = sc.nextInt();
System.out.println((n&1)==1?"ODD":"EVEN");
}
}
