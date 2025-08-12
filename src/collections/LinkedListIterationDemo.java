package collections;

import java.util.*;

public class LinkedListIterationDemo {
	public static void main(String[] args) {
		LinkedList<Integer> li=new LinkedList<>();
		for(int i=0;i<10;i++) {
			li.add(i);
		}
			System.out.println(li);
			Iterator<Integer> j=li.iterator();
			
			while(j.hasNext()) {
				System.out.println(j.next());
			}
			for(Integer i:li) System.out.println(i);
		}
		
	}

