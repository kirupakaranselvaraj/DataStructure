package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTypesDemo {
	public static void main(String[] args) {
		Map<Integer,String> hm=new HashMap<>();
		Map<Integer,String> lhm=new LinkedHashMap<>();
		Map<Integer,String> tm=new TreeMap<>();
		
		hm.put(0,"hiii");
		hm.put(1,"hi! My Name is Karan.");
		hm.put(0,"hiii");
		hm.put(0,"hiii");
		hm.put(0,"hiii");
		hm.put(0,"hiii");
		
		System.out.println(hm.get(1));
	}
}
