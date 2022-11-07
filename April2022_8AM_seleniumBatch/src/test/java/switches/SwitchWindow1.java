package switches;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindow1 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.icicibank.com/");
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		while(!wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='PL'][@class='lazy loaded']"))).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='banner-slider i-home-banner desktop slick-initialized slick-slider slick-dotted']/button[contains(text(),'Next')]")).click();
		}
		driver.findElement(By.xpath("//img[@alt='PL'][@class='lazy loaded']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> nwinds = new ArrayList<String>(windows);
		
		for(String i :nwinds)
		{
			System.out.println(i);
		}
		
		driver.switchTo().window(nwinds.get(1));
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		driver.close();
		
		driver.switchTo().window(nwinds.get(0));
		
		String title2 = driver.getTitle();
		System.out.println(title2);
	}

}
