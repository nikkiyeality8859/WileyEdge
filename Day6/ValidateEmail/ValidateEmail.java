package Day6Assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 2. Create custom/user defined exception to validate the email. 
Sample output1: 
Entered email address : mandarmjog@gmail.com
Your email address is valid.
Sample output2:
Entered email address: wiley@g@.com
Your email address is invalid
Sample output3:
Entered email address: .wi@.gmail@1234
Your email address is invalid
 */
public class ValidateEmail {

	public static void checkEmail(String email) throws ValidateException {
		 String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
		 Pattern pattern = Pattern.compile(regex);  
		 boolean b=pattern.matcher(email).matches();
		 if(b) {
			 return ;
		 }else {
			 throw new ValidateException();
		 }
		 
	}
	public static void main(String[] args) {
		String email="mandarmjog@gmail.com";
		
    try {
		checkEmail(email);
		System.out.println("your email address is valid");
	} catch (ValidateException e) {
		// TODO Auto-generated catch block
		System.out.println("your email address is not valid");
	}
  
    	
    
	}

}
