package encryption

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Encryption{
	public static void main(String[] args){
		HashMap<Character, Character> hashMap =
			new HashMap<Character, Character>();
		hashMap.put('a', 'v');
		hashMap.put('b', 'e');
		hashMap.put('c', 'k');
		hashMap.put('d', 'n');
		hashMap.put('e', 'o');
		hashMap.put('f', 'h');
		hashMap.put('g', 'z');
		hashMap.put('h', 'f');
		hashMap.put('i', ' ');
		hashMap.put('j', 'i');
		hashMap.put('k', 'l');
		hashMap.put('l', 'j');
		hashMap.put('m', 'x');
		hashMap.put('n', 'd');
		hashMap.put('o', 'm');
		hashMap.put('p', 'y');
		hashMap.put('q', 'g');
		hashMap.put('r', 'b');
		hashMap.put('s', 'r');
		hashMap.put('t', 'c');
		hashMap.put('u', 's');
		hashMap.put('v', 'w');
		hashMap.put('w', 'q');
		hashMap.put('x', 'u');
		hashMap.put('y', 'p');
		hashMap.put('z', 't');
		hashMap.put(' ', 'a');
		
		System.out.println(args[0]);
		char[] c = args[0].toCharArray();
		for (int i = 0; i < c.length; i ++){
			if (Character.isUpperCase(c[i]))
				c[i] = Character.toLowerCase(c[i]);
			System.out.print(hashMap.get(c[i]));
		}
		System.out.println();
	}
}
