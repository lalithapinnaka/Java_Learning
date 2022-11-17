
public class PrintDuplicates {

	public static void main(String[] args) {

		//Approach1
		//Used contains() API method in String
		String s1 =" abcd abcd ";
		String s2 = "";
		String s3 = "";
		
		s1=s1.trim();
		s1=s1.replace(" ", "");

		for(int i=0; i<s1.length();i++) {

			CharSequence ch = Character.toString(s1.charAt(i));

			if(!s2.contains(ch)) {
				s2=s2+s1.charAt(i);
			}
			else {
				s3=s3+s1.charAt(i);
			}
		}
		System.out.println("The duplicates in a given String " + s1 + " are " + s3);


		//Approach2
		//Used indexOf() API method in String
		String s4 ="";
		String s5="";

		for(int i=0;i<s1.length();i++) {
			if(s4.indexOf(s1.charAt(i))<0) {
				s4=s4+s1.charAt(i);
			}
			else {
				s5=s5+s1.charAt(i);
			}
		}
		System.out.println("The duplicates in a given String " + s1 + " are " + s5);
	}
}

