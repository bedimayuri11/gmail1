package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Feature1
{
	public RemoteWebDriver driver;
	
	@Given("open {string} Browser page")
	public void method1(String bn)
{
    if(bn.equalsIgnoreCase("chrome"))
    {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    }
}
@When("launch site using {string}")
public void method2(String url)
{
    driver.get(url);
}

@When("do login using {string} and {string}")
public void method3(String un, String pwd) throws Exception 
{
   driver.findElement(By.name("identifier")).sendKeys(un);
   driver.findElement(By.xpath("//span[text() = 'Next']")).click();
   Thread.sleep(3000);
   driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys(pwd);
   driver.findElement(By.xpath("//span[text() = 'Next']")).click();
   Thread.sleep(3000);
}

@Then("compose is displayed")
public void method4() 
{
    if(driver.findElement(By.xpath("//div[text() = 'Compose']")).isDisplayed())
{
	System.out.println("Compose is displayed");
}
    else
    {
    	System.out.println("Compose is not displayed");
    	System.exit(0);// 0 is forcibly
    }
}

@When("click on compose")
public void method5()
 
 {
	 driver.findElement(By.xpath("//div[text() = 'Compose']")).click();   
}

@Then("field should be displayed")
public void method6()
{
 if(driver.findElement(By.name("to")).isDisplayed())
 {
	 System.out.println("field are displyed");
 }
 else 
 {
	 System.out.println("field are not displyed");
 }
}

@When ("fill field with {string}, {string}, {string} and {string}")
public void method7(String to, String sub, String body, String attach) throws Exception
{
    driver.findElement(By.name("to")).sendKeys(to);
    driver.findElement(By.name("subjectbox")).sendKeys(sub);
    driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(body);
    driver.findElement(By.name("Filedata")).sendKeys(attach);
    Thread.sleep(10000);
}

@Then("send is enabled")
public void method8()
{
   if(driver.findElement(By.xpath("//div[text() = 'Send']")).isDisplayed())
   {
	   System.out.println("Send is enabled");
   }
   else
   {
	   System.out.println("Send is disabled");
	   System.exit(0);// 0 is forcibly
   }
}

@When("click on send")
public void method9()
{
    driver.findElement(By.xpath("//div[text() = 'Send']")).click();
}

@Then("{string} should be displayed")
public void method10(String excepted) 
{
 String actual =driver.findElement(By.xpath("//div[@role='alert']/descendan::span[2]")).getText();
		 if(excepted.equalsIgnoreCase(actual))
		 {
			 System.out.println("Correct message");
		 }
		 else
		 {
			 System.out.println("Wrong message");
			 System.exit(0);
		 }
}

 @When("do logout")
public void method11() throws Exception
{
	 driver.switchTo().frame(2);
    driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/img")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("Sign out")).click();
    Thread.sleep(3000);
    driver.switchTo().defaultContent();
}
    
@Then("login page should be displayed")
public void method12()
{
	if(driver.findElement(By.xpath("//span[text() = 'Choose an account']")).isDisplayed())
{
		System.out.println("Successful logout");
}
else
{
		System.out.println("unsuccessful logout");
 }
}

@Then("closed site")
public void closed_site()
{
    driver.close();
}

}
