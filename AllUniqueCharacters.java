
public class AllUniqueCharacters {

	public static void main(String[] args) {
		String s1 =" abcc ";
		int count=0;

		s1=s1.trim();
		s1=s1.replace(" ", "");
		s1=s1.toLowerCase();

		for(int i=0;i<s1.length();i++) {
			for(int j=i+1;j<s1.length();j++) {
				if(s1.charAt(i) == s1.charAt(j)) {
					count++;
					break;
				}
			}
		}
		if(count==0) {
			System.out.println("The given string " + s1 + " contain all the unique characters");
		}
		else {
			System.out.println("The given string " + s1 + " doesn't contain all the unique characters");
		}
	}
}
