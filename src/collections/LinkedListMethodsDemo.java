package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class LinkedListMethodsDemo {
	public static void main(String[] args) {
		List<Integer> ll=new LinkedList<>();
		
		ll.add(453);
		ll.add(6254);
		ll.add(3543);
		ll.add(8798);
		ll.add(87785);
		ll.addFirst(2345);
		System.out.println(ll.contains(5));
		System.out.println(ll);
	}	
}
