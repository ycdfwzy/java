package numtreeset

import java.util.*;

public class NumTreeSet{
	public static void main(String[] args){
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		Random rand = new Random();
		for (int i=0; i<80; i++)
			tSet.add(rand.nextInt(100)+1);
		
		System.out.println("Total: "+tSet.size());
		Iterator<Integer> itr = tSet.iterator();
		while( itr.hasNext() ){
			int value = itr.next();
			System.out.println(value);
		}
	}
}