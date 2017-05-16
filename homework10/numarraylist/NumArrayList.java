package numarraylist;

import java.util.*;

public class NumArrayList{
	public static void main(String args[]){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		System.out.println("Before deletion:");
		for (int i=0; i<20; i++)
			list.add(rand.nextInt(1001));

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()){
			Integer value = itr.next();
			System.out.println(value);
			if (value < 500)
				itr.remove();
		}

		System.out.println("After deletion:");
		itr = list.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}
}
