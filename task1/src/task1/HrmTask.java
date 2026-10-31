package task1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HrmTask {
	WebDriverWait wait;
	public String baseUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	@BeforeTest
	public void launch_page() {
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.get(baseUrl);
  }
	@Test(priority=0)
	public void login() {
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginBtn.click();
	}
	
	@Test(priority=1)
	public void navigate_pim() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement pim=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")));
		pim.click();
	}
	
	@Test(priority=2)
	public void add_employee() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement addEmp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]")));
		addEmp.click();
		WebElement fName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		WebElement mName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName")));
		WebElement lName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
		fName.sendKeys("abc");
		mName.sendKeys("user");
		lName.sendKeys("user1");
		WebElement save=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")));
		save.click();
	}

}
