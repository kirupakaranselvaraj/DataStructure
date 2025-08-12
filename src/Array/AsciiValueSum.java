package Array;

public class AsciiValueSum {
	public static void main(String[] args){
		String data="abc";
		int weight = 0;
		for(int v=0;v<data.length();v++) {
			weight+=data.charAt(v)-96;
		}
		System.out.println(weight);
	}
}