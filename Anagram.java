import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String s1="ftsa";
		String s2="fast";
		String s3="";
		String s4="";

		//This block of code used to convert String s1 into lowercase if it has uppercase letters
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) >= 'A' && s1.charAt(i) <= 'Z') {
				s3=s3+(char)(s1.charAt(i)+32);
			}

			else {
				s3=s3+s1.charAt(i);
			}
		}

		//This block of code used to convert String s2 into lowercase if it has uppercase letters
		for(int i=0; i<s2.length(); i++) {
			if(s2.charAt(i) >= 'A' && s2.charAt(i) <= 'Z') {
				s4=s4+(char)(s2.charAt(i)+32);
			}

			else {
				s4=s4+s2.charAt(i);
			}
		}

		//Converting String into an array of Characters
		char[] ch1 = s3.toCharArray();
		char[] ch2 = s4.toCharArray();

		char tmp1;
		char tmp2;

		//Sorting the first array
		for(int i=0; i<ch1.length; i++) {
			for(int j=i+1; j<ch1.length;j++) {
				if(ch1[i]>ch1[j]) {
					tmp1 = ch1[i];
					ch1[i] = ch1[j];
					ch1[j] = tmp1;
				}
			}
		}

		//Sorting the second array
		for(int i=0; i<ch2.length; i++) {
			for(int j=i+1; j<ch2.length;j++) {
				if(ch2[i]>ch2[j]) {
					tmp2 = ch2[i];
					ch2[i] = ch2[j];
					ch2[j] = tmp2;
				}
			}
		}

		//Comparison of sorted arrays
		if(Arrays.equals(ch1, ch2)) {
			System.out.println("The given Strings " + s1 + " " + s2 + " is an ANAGARM");
		}

		else {
			System.out.println("The given Strings " + s1 + " " + s2 + " is not an ANAGARM");
		}
	}
}
