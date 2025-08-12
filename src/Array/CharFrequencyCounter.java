package Array;

import java.util.*;
public class CharFrequencyCounter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String news = "";
        for(int k=0; k<s.length(); k++) {
            if(news.indexOf(s.charAt(k))==-1) {
            news+=s.charAt(k);
            int count =1;
                for(int i=k+1; i<s.length(); i++) {
                    if(s.charAt(k)==s.charAt(i))
                    count++;
                }
                System.out.println(s.charAt(k)+" : "+count);
            }
        }
        sc.close();
    }
  
}