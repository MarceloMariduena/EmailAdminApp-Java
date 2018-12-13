package emailApp;

public class EmailApp {
	public static void main(String[] args) {
		
		// Testing with parameters
		Email em1 = new Email("Ricky", "Spanish");
		em1.showInfo();
		
		// Spacing
		System.out.println();
		
		//Testing without parameters
		Email em2 = new Email();
	}
}
