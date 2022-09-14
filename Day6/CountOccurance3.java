package Day6Assignment;
//count the occurance of character in a string
public class CountOccurance3 {
	private static int count(String str, char a) {
		int occurance=0;
		for(int i=0;i<str.length();i++) {
			if((str.charAt(i))==a  ) {
				occurance++;
			}
		}
		return occurance;
	}

	public static void main(String[] args) {
		String str="Missipi";
		char a='i';
		int ans=count(str,a);
System.out.println(a +" occurrs "+ans+" in " +str);
	}

	

}
