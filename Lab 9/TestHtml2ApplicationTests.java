package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestHtml2ApplicationTests {
	
	public static WebDriver driver; 
	
	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ricardo Luna\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect() throws Exception {
		// When
		driver.get("http://automationpractice.com/index.php");
		String title = driver.getTitle();
		
		// Then
		assertEquals("My Store", title);
	}
	
	
	@Test
	public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed() throws Exception {
		// When 
		successfulLogin();
		String title = driver.getTitle();
		
		// Then
		assertEquals("My account - My Store", title);
		logout();
	}
	
	
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed() throws Exception {
		// When
		failedLogin();
		String title = driver.getTitle();
		
		// Then
		assertEquals("Login - My Store", title);
	}
	
	
	@Test
	public void givenAClient_whenEnteringWrongCredentials_thenErrorMessageIsDisplayed() throws Exception {
		// When
		failedLogin();
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li"));
		
		// Then
		assertEquals("Authentication failed.", errorMessage.getText());
	}
	
	
	@Test
	public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsDisplayed() throws Exception {
		// When 
		successfulLogin();
		
		WebElement productSearch = driver.findElement(By.id("search_query_top"));
		productSearch.sendKeys("Homework");
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
				
		WebElement errorMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		assertEquals("No results were found for your search \"Homework\"", errorMessage.getText());
		logout();
	}
	
	
	@Test
	public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed() throws Exception {
		// When
		successfulLogin();
		
		WebElement productSearch = driver.findElement(By.id("search_query_top"));
		productSearch.sendKeys("");
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
		
		WebElement errorMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		assertEquals("Please enter a search keyword", errorMessage.getText());
		logout();
	}
	
	
	@Test
	public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed() throws Exception {
		// When
		successfulLogin();
		logout();
		String title = driver.getTitle();
		
		// Then
		assertEquals("Login - My Store", title);
	}
	
	
	public void successfulLogin() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("ricardo@themoondev.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("Zonezero123");
		WebElement submitButton= driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
	}
	
	
	public void failedLogin() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("r@themoondev.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("Zonezero123");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
	}
	
	
	public void logout() {
		WebElement logOut = driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout=']"));
		logOut.click();
	}
	
}
