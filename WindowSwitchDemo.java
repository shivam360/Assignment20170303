package multiple_window;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class WindowSwitchDemo {
		
		// Create a new instance of the Chrome driver
				
	public static void main(String[] args) throws InterruptedException{
		String chromepath="D:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
	   WebDriver driver=new ChromeDriver();
	   
	   driver.manage().window().maximize();
	   
	   driver.get("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");
	   
	   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	   
	   String parent_window= driver.getWindowHandle();
	  // System.out.println("Before Switching the title is="+driver.getTitle());
	   
	   driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]")).click();
	   
	   Set<String> window = driver.getWindowHandles();
		   for(String s:window)
		   {driver.switchTo().window(s);
		    if(driver.getCurrentUrl().equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
		    	driver.close();
		    	System.out.println("https://twitter.com/intent/follow?screen_name=seleniumeasy");
		    }
		   
		   driver.switchTo().window(parent_window);
		   //driver.navigate().to("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		   
		   WebElement LikeusonFacebook = driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook ')]"));
			   LikeusonFacebook.click();
			  Set<String> window2 = driver.getWindowHandles();
			   //System.out.println(window2.size());
			   for(String s:window2)
			   {driver.switchTo().window(s);
			    if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy"))
			    	driver.close();
			    	System.out.println("https://www.facebook.com/seleniumeasy");
			    }
			  
			   driver.switchTo().window(parent_window);
			   //driver.navigate().to("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");
			   WebElement Follow_Twitter_and_Facebook = driver.findElement(By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]"));
 		
 			  Follow_Twitter_and_Facebook.click();
 			  Set<String> window3 = driver.getWindowHandles();
 			   for(String s:window3)
 			   {
 				   driver.switchTo().window(s);
 			    if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy"))
 			    	System.out.println("https://www.facebook.com/seleniumeasy");
 			    else if(driver.getCurrentUrl().equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
 			    	driver.close();
 			    	System.out.println("https://twitter.com/intent/follow?screen_name=seleniumeasy");
 			   }
 			  driver.switchTo().window(parent_window);
	   
	}
}