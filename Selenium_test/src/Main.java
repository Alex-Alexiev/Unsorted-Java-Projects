import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.Robot;


public class Main {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/aalexiev/Google Drive/Programming/Selenium/Chrome_Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Robot r = new Robot();
		driver.manage().window().maximize();
		driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
		while (true) {
			for (int i = 850; i > 840; i--){
				
				if (r.getPixelColor(i, 425).getRed() < 100){
					driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
					i = 700;
			 	}

			}
			if (r.getPixelColor(1100, 380).getRed() < 100) {
				driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
			}

		}
	}
}
