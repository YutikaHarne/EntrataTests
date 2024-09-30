package entrata;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EntrataTest {
	
  WebDriver driver;
  JavascriptExecutor js = (JavascriptExecutor) driver;
  
  @BeforeMethod
  public void openwebsite() throws InterruptedException {
	  driver = new ChromeDriver();
	  
//	  Applied implicit wait for 5 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
//	  To get the url in browser
	  driver.get("https://www.entrata.com/b");
	  System.out.println("Chrome Browser opened");
//	  Used maximize method to maximize the window
	  driver.manage().window().maximize();
	  System.out.println("Window Maximized");
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	  To accept the cookies
	  driver.findElement(By.xpath("//a[@id='cookie-accept']")).click();
	  System.out.println("Cookie accepted");  
  }		
  
@Test(priority=1,enabled=true)
public void watchDemo() throws InterruptedException {
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	Check Watch demo button is clickable and opening next page or not
	WebElement watchDemo = driver.findElement(By.xpath("//a[@href='https://go.entrata.com/watch-demo.html']"));
	watchDemo.click();
	String Title = driver.getTitle();
	System.out.println(Title);
    System.out.println("button is clicked");	
    
 // Add assertion to verify the page title after clicking the button
    String expectedTitle = "Entrata | Optimize Property Management with One Platform";  
    String actualTitle = driver.getTitle();
    assert actualTitle.equals(expectedTitle) : "Page title mismatch! Expected: " + expectedTitle + ", but got: " + actualTitle;
    
    System.out.println("Test 1 is successfully executed");
}
  
 @Test(priority=2, enabled=true)
  public void scheduleYourDemo() throws InterruptedException {
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	 get the main window
	  String mainWindow = driver.getWindowHandle();	  
	  System.out.println("Main Window Handle: " + mainWindow);

	  driver.findElement(By.xpath("(//a[@href='https://go.entrata.com/schedule-demo.html'])[1]")).click();   // This should open new tab
	  
//    Get all window handles
      Set<String> allWindows = driver.getWindowHandles();
      
//    Switch focus to the new tab
      for (String windowHandle : allWindows) {
          if (!windowHandle.equals(mainWindow)) {
              driver.switchTo().window(windowHandle);  // Switch to the new tab
              System.out.println("Switched to new tab with handle: " + windowHandle);
              break;
          }
          }
//    Now we can perform action on child window
      System.out.println("Title of the child tab: " + driver.getTitle());
     
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//    Fill the form on child window
//    Add First Name in form
      driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Yutika");
//    Add Last Name in form  
      driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Harne");
//    Add Mail in form  
      driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("harneyutika@gmail.com");
//     Add Company name in form
      driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("YutikaHarne");
//      Add mobile number in form
      driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("8585858585");
//      Select the dropdown action in form
      WebElement unitCount=driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
      unitCount.click();
      Select s = new Select(unitCount);
      s.selectByIndex(1);
//      Add Job title in form
      driver.findElement(By.xpath("//input[@id='Title']")).sendKeys("QAEngineer");
//     Select dropdown option
      WebElement iAm =driver.findElement(By.xpath("//select[@id='demoRequest']"));
      Select s1 = new Select(iAm);
      s1.selectByIndex(1);
      
      
//    Switch back to the main window
      driver.switchTo().window(mainWindow);
      System.out.println("Switched back to the main tab with title: " + driver.getTitle());

      System.out.println("Test 2 is successfully executed");
  }
 
  @Test(priority=3, enabled=true)
  public void registerNow() throws InterruptedException {
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	  click on register now
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement registerNow = driver.findElement(By.cssSelector("a[href='https://basecamp.entrata.com/']"));
	  js.executeScript("arguments[0].click();", registerNow);
	 
//	  click on next page register now
	  WebElement registerNow1 = driver.findElement(By.xpath("//a[@class='bc-nav-button w-button']"));
	  js.executeScript("arguments[0].click();", registerNow1);
	  
//	  Add first name in register form and to scroll to Firstname WebElement
      WebElement firstName = driver.findElement(By.xpath("//input[@aria-label='First name']"));
      js.executeScript("arguments[0].scrollIntoView(true);", firstName);
      firstName.sendKeys("Yutika");
//	  Applied implicit wait for 2 seconds
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//    Add Last name in register form  
      driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("Harne");
//    Add Company name in register form
      driver.findElement(By.xpath("//input[@aria-label='Company']")).sendKeys("YH");
//    Add Title name in register form  
      driver.findElement(By.xpath("//input[@aria-label='Title']")).sendKeys("YNH");
//    Add Mail name in register form 
      driver.findElement(By.xpath("//input[@aria-label='Email Address']")).sendKeys("harneyutika@gmail.com");
//    Add Mobile number in register form 
      driver.findElement(By.xpath("//input[@aria-label='Mobile']")).sendKeys("+91 8585858585");
//    Add Address name in register form 
      driver.findElement(By.xpath("//input[@aria-label='Address 1']")).sendKeys("ABC");
//    Add Zip Code name in register form   
      driver.findElement(By.xpath("//input[@aria-label='ZIP/Postal Code']")).sendKeys("411057");
//    To click on Cancel Button in Register Now
      driver.findElement(By.xpath("//button[@id='exit']")).click();

      System.out.println("Test 3 is successfully executed");
  }
  
  @Test(priority=4, enabled=true)
  public void clickOnLogoToGoOnHomePage () throws InterruptedException {
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	  To click on Explore more
	  driver.findElement(By.xpath("//div[text()='Explore More']")).click();
//	  Click on Entrata logo to go on home page again
	  driver.findElement(By.xpath("//a[@aria-label='home']")).click(); 
	  
	  System.out.println("Test 4 is successfully executed");
  }
  
  
  @Test(priority=5, enabled=true)
  public void basecampJourney() throws InterruptedException {
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  
//	  Click on register now and check Overview, Why Attend, Keynotes, Agenda, Pricing, FAQ's 
//	  working as per functionality or not  
	  driver.findElement(By.xpath("(//div[@class='position-relative'])[1]")).click();
//	   is added for delay and let page get load completely
//	  Click on Overview to check pages are scrolling correctly or not
	  driver.findElement(By.xpath("(//div[text()='Overview'])[2]")).click();
	  
//	  Click on Why Attend to check pages are scrolling correctly or not
	  driver.findElement(By.xpath("(//div[text()='Why Attend'])[2]")).click();
	
//	  Click on Keynotes to check pages are scrolling correctly or not
	  driver.findElement(By.xpath("(//div[text()='Keynotes'])[2]")).click();

//	  Click on Agenda to check page is switching to agenda page or not
	  driver.findElement(By.xpath("(//div[text()='Agenda'])[2]")).click();
//	  To go back on Base Camp Journey Page
	  driver.navigate().back();
	  
//	  Click on Pricing to check pages are scrolling correctly or not
	  driver.findElement(By.xpath("(//div[text()='Pricing'])[2]")).click();
	  
//	  Click on FAQ's to check pages are scrolling correctly or not 
	  driver.findElement(By.xpath("(//div[text()='FAQ'])[2]")).click();
	  
	  System.out.println("Test 5 is successfully executed");
  }
  	
  @Test(priority=6, enabled=true)
  public void seeHowItWorks() throws InterruptedException {
//	  To click on How It Works and check page is switching on next page having info and Watch Now button(Switch to respective page)
	  driver.findElement(By.xpath("//div[text()='See How it Works']")).click();
//    To click on Watch now to check page is navigating to page having video
	  driver.findElement(By.xpath("//a[@href='https://go.entrata.com/watch-tei-webinar.html']")).click();
	  
	  
	  System.out.println("Test 6 is successfully executed");
  }
  
  @Test(priority=7, enabled=true)
  public void product() throws InterruptedException {
//	  Applied implicit wait for 3 seconds
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  
//	  Click on Products
	  WebElement products = driver.findElement(By.xpath("(//div[text()='Products'])[1]"));
      Actions act = new Actions(driver);
      act.moveToElement(products).build().perform();
//     To Go to message centre page
      driver.navigate().to("https://www.entrata.com/products/message-center");
//    To click on Watch Demo to check page is navigating to form page  
      driver.findElement(By.xpath("(//a[@href='https://go.entrata.com/schedule-demo.html'])[1]")).click();
//    To apply wait on WebElements for 3 sec till element get find  
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//    Add First Name in form  
      driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Yutika");
//    Add Last Name in form
      driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Harne");
//    Add Mail in form
      driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("harneyutika@gmail.com");
//    Add Company Name in form  
      driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("YutikaHarne");
//    Add Mobile Number in form  
      driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("8585858585");
//    To select dropdown option  
      WebElement unitCount=driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
      unitCount.click();
      Select s = new Select(unitCount);
      s.selectByIndex(1);
//    Add Title in form  
      driver.findElement(By.xpath("//input[@id='Title']")).sendKeys("QAEngineer");
//    To select dropdown option   
      WebElement iAM =driver.findElement(By.xpath("//select[@id='demoRequest']"));
      Select s1 = new Select(iAM);
      s1.selectByIndex(1);
//    To navigate to previous page
      driver.navigate().back();
     
//    Again to navigate to homepage  
      driver.navigate().back();

      System.out.println("Test 7 is successfully executed");
  }
  
  @AfterMethod
  public void logout() {
//	To close the browser
	  driver.quit();
  }
}
