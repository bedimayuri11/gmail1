package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail {

	public static void main(String[] args) throws Exception
	{
		// Open Chrome Browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("mayyarosh1111", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Apple_123",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[@aria-hidden='true'])[2]")).click();
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("(//iframe[@role='presentation'])[2]"));
		driver.switchTo().frame(e);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text() = 'Sign out']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
	}

}
