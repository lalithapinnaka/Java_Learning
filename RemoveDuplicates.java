
public class RemoveDuplicates {

	public static void main(String[] args) {
		String s1 =" abcdeabc efg ";
		String s2 ="";
		String s3 ="";

		s1=s1.trim();
		s1=s1.replace(" ", "");
		
		//Approach1
		//Using contains() API method in String
		for(int i=0; i<s1.length();i++) {
			
			CharSequence ch = Character.toString(s1.charAt(i));
			
			if(!s2.contains(ch)) {
				s2=s2+s1.charAt(i);
			}
		}
		System.out.println("The result String after the duplicates removal from a given String " + s1 + " is " + s2);
		
		//Approach2
		//Used indexOf() API method in String
		for(int i=0;i<s1.length();i++) {
			
			if(s3.indexOf(s1.charAt(i))<0) {
				s3=s3+s1.charAt(i);
			}
		}
		System.out.println("The result String after the duplicates removal from a given String " + s1 + " is " + s3);
	}
}
