class Authentication{
	
	void login(String email, String password) {
		System.out.println("logging in with user: "+email +" and passoword");
	}
	void login(String phone, int opt) {
		System.out.println("logging in with phone number : "+phone +" and opt");
	}
}
class Theme{
	void themeColorScheme() {
		System.out.println("Primary color : red");
		System.out.println("Secondary color : white");
	}
	void darkToenable(boolean enable) {};
}

class CustomTheme extends Theme{
	void themeColorScheme() {
		
		System.out.println("Primary color : green");
		System.out.println("Secondary color : yellow");
	}
	//void darkToenable(boolean enable, int brightnessLevel) {};
	void darkToenable(boolean enable) {};
}
public class OverloadingvsOverriding {

	public static void main(String[] args) {


	}
	
}
