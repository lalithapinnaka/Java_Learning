public class Pangram {

	public static void main(String[] args) {
		String s1="THE QUICK BROWN FOX JUMPS OVER LAZY DOG";
		String s2="";
		boolean isPangram=true;
		int[] arr = new int[26];

		s2=s2+s1.trim();
		s2=s2.replace(" ", "");

		char[] ch = s2.toCharArray();

		//Sorting of array
		for(int i=0; i<ch.length; i++) {
			for(int j=i+1; j<ch.length;j++) {
				if(ch[i]>ch[j]) {
					char tmp = ch[i];
					ch[i] = ch[j];
					ch[j] = tmp;
				}
			}
		}

		//Updating the array arr based on the characters in String
		for(int i=0;i<ch.length;i++) {
			int index = ch[i]-65;
			arr[index]++;
		}
		
		//Traversing arr
		for (int c : arr) {
			if(c==0) {
				System.out.print("The given String " + s1 + " is not a Pangram");
				isPangram=false;
			}
		}
		
		if(isPangram) {
			System.out.print("The given String " + s1 + " is a Pangram");
		}
	}
}
