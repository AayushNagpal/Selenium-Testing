

import static com.heliumhq.API.*;

public class GoogleSearchExample {
	public static void main(String[] args) {
		startChrome();
		goTo("google.com/?hl=en");
		write("uno");
		press(ENTER);
		click("University of New Orleans: Home");
		hover("ABOUT");
		press(ESCAPE);
		System.out.println("Hover test passed...");
		
		click(Point (500,500));
		
		click ("Accepted Students");
		click ("Moodle");
		write ("anagpal@uno.edu","Username");
		write ("", "Harekrishnarama@25");
		waitUntil(Text("Finished!").exists);
		
		
			System.out.println("Test passed!");
		
		
		
		killBrowser();
	}
}