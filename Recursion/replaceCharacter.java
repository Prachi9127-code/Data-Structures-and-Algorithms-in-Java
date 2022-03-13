package Recursion;

public class replaceCharacter {
	
	public static String replace(String input, char c1, char c2) {
		if(input.length() == 0) {
			return input;
		}
		else {
			char first = c1 == input.charAt(0)? c2 : input.charAt(0);
			return first + replace(input.substring(1), c1, c2);
		}
	}

	public static void main(String[] args) {
		String str = "abca";
		System.out.println(replace(str, 'a', 'x'));

	}

}
