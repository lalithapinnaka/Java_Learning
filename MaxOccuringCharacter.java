
public class MaxOccuringCharacter {

	public static void main(String[] args) {
		String s1 =" abbcccc DDddd ";
		int[] count = new int[26];
		int max = -1;
		char maxOcuuringCharacter= '0';

		s1=s1.trim();
		s1=s1.replace(" ", "");
		s1=s1.toLowerCase();

		//Updating the count array based on the characters in String
		for(int i=0;i<s1.length();i++) {
			int index = s1.charAt(i)-97;
			count[index]++;
		}
		
		//Traversing the count array 
		for(int i=0;i<count.length;i++) {
			if(max<count[i]) {
				max=count[i];
				maxOcuuringCharacter = (char)(i + 97);
			}
		}
		System.out.println("The maximum occuring character in a given String " + s1 + " is " + maxOcuuringCharacter + " and it was repeated " + max + " times.");
	}
}
