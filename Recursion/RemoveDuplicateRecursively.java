package Recursion;

import java.util.*;

public class RemoveDuplicateRecursively {
	
	public static String removeconsecutivedeplicates(String s) {
		if(s.length()<=1) {
			return s;
		}
		if(s.charAt(0)==s.charAt(1)) {
			return removeconsecutivedeplicates(s.substring(1));
		}else {
			return s.charAt(0) + removeconsecutivedeplicates(s.substring(1));
		}
	}

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		String input = s.next();
		System.out.println(RemoveDuplicateRecursively.removeconsecutivedeplicates("aabccba"));
	}
}
