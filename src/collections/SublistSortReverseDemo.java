package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class SublistSortReverseDemo {
	public static void main(String[] args) {
		
		int[] arr= {1,2,3,4,5,6,7,8};
		LinkedList<Integer> li=new LinkedList<Integer>();
		for(int i:arr) {
			li.add(i);
		}
		Collections.sort(li.subList(0,li.size()/2));
		Collections.reverse(li.subList(li.size()/2+1,li.size()));
		
		
		System.out.println(li);
	}
}
	
	

