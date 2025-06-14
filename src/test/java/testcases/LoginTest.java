package testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void Login()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("ravinderKumar");
		driver.findElement(By.id("password")).sendKeys("Password@123456");
		driver.findElement(By.id("login")).click();
		
		//Explicit Wait added.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
		
		driver.quit();
	}
	
	
}
