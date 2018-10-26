package com.main.test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
public class Saplingtest {
public WebDriver driver;
Properties p;
FileInputStream fi;
WebDriverWait wait;
  /*@Test
  public void Products() throws InterruptedException {
 	  Actions ac=new Actions(driver);
	  WebElement products=driver.findElement(By.xpath("//*[text()='Products']"));
	  Thread.sleep(2000);
	  ac.moveToElement(products).click().perform();
	  Thread.sleep(2000);
	  WebElement Corehr=driver.findElement(By.xpath("//*[@id=\"hs_menu_wrapper_module_14694228367545\"]/ul/li[1]/ul/li[1]/a"));
	  ac.moveToElement(Corehr).click().perform();
	  Thread.sleep(2000);
	  String Coreurl=driver.getCurrentUrl();
	  String ValidateCoreurl="corehr";
	  if(Coreurl.contains(ValidateCoreurl)) {
		  Reporter.log("Core Hr Link Opened",true);
	  }
	  else {
		  Reporter.log("Core Hr Link failed to Open",true);
	  }
 }*/
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		com.main.sapling.AdminloginPage login=PageFactory.initElements(driver, com.main.sapling.AdminloginPage.class);
		login.Verify_Login("chaitanya1@test.com", "admin123!");
		Thread.sleep(10000);
		String url=driver.getCurrentUrl();
		Reporter.log(url ,true);
		String verify="updates";
		
		if(url.contains(verify)) {
			Reporter.log("Login sucess",true);
		}else {
			Reporter.log("Login unsucess",true);
		}
	}
	

  @BeforeTest
  public void beforeTest() throws IOException {
	  OperaOptions options = new OperaOptions();
	  options.setBinary("C:\\Users\\Dizerc1\\AppData\\Local\\Programs\\Opera\\56.0.3051.52\\opera.exe");
	  driver = new OperaDriver(options);
	 // driver =new ChromeDriver();
	  p =new Properties();
	  fi =new FileInputStream("Sapling.properties");
	  p.load(fi);
	  driver.get(p.getProperty("objurl"));
	  driver.manage().window().maximize();
  }
  @AfterTest
  public void TearDown() {
	  driver.close();
 }
}
