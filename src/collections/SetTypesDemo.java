package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetTypesDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		Set<Integer> hs=new HashSet<>();
		Set<Integer> lhs=new LinkedHashSet<>();
		Set<Integer> ts=new TreeSet<>();
		
		for(int i=0;i<10;i++) {
			lhs.add(sc.nextInt());
		}
		System.out.println(lhs);

	}
}
