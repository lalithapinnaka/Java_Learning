
public class CountCharacters {

	public static void main(String[] args) {

		String s1 = "acDeou9ia*]";
		String s2 ="";
		int vowelCount = 0;
		int consonantCount = 0;
		int numberCount = 0;
		int symbolCount = 0;

		//This block of code used to convert String into lowercase if it has uppercase letters
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) >= 'A' && s1.charAt(i) <= 'Z') {
				s2=s2+(char)(s1.charAt(i)+32);
			}

			else {
				s2=s2+s1.charAt(i);
			}
		}
		
		//This block of code is used to print the count of vowels,consonants,numbers,symbols
		for(int i=0; i<s2.length(); i++) {
			if(s2.charAt(i) == 'a'|| 
					s2.charAt(i) == 'e' ||
					s2.charAt(i) == 'i' ||
					s2.charAt(i) == 'o' ||
					s2.charAt(i) == 'u') 
			{
				vowelCount++;
			}

			else if(s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z') {
				consonantCount++;
			}

			else if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
				numberCount++;
			}

			else {
				symbolCount++;
			}
		}
		
		System.out.println("The count of vowels present in a given String " + s1 + " is " + vowelCount);
		System.out.println("The count of consonants present in a given String " + s1 + " is " + consonantCount);
		System.out.println("The count of numbers present in a given String " + s1 + " is " + numberCount);
		System.out.println("The count of symbols present in a given String " + s1 + " is " + symbolCount);
	}
}
