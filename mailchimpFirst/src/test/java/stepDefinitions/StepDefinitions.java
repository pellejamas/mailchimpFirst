package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

	@Before
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Startar Chrome
		driver.get("https:login.mailchimp.com/signup"); // Navigerar till mailchimp.com
		Thread.sleep(3000); //V�nta 3sek
		driver.findElement(By.id("onetrust-accept-btn-handler")).click(); //Klickar p� Accept All Cookies
	}

	@Given("I have entered {string} as a mail")
	public void i_have_entered_string_as_a_mail(String String1) throws InterruptedException {
		WebElement email = driver.findElement(By.id("email")); // Hittar email-rutan
		email.sendKeys("Hejhej@mail.com"); // Skriver in en email
		Thread.sleep(3000); //V�nta 3sek
	}

	@And("I have also entered {string} as an username")
	public void i_have_also_entered_string_as_an_username(String String1) throws InterruptedException {
		WebElement user = driver.findElement(By.id("new_username")); // Hittar anv�ndarnamnet-rutan
		user.sendKeys("pollens1"); // Skriver in ett anv�ndarnamn
		Thread.sleep(3000); //V�nta 3sek
	}
	@And("I have also entered {string} as an password")
	public void i_have_also_entered_string_as_an_password(String string1) throws InterruptedException {
		WebElement password = driver.findElement(By.id("new_password")); // Hittar l�senords-rutan
		password.sendKeys("Pellehejsan1!"); // Skriver in ett l�senord
		Thread.sleep(3000); //V�nta 3sek
	}
	
	@When("I press sign up")
	public void i_press_sign_up() {
		driver.findElement(By.id("create-account")).click(); // Klickar p� sign up
	}

	@Then("I should get the correct {string} output")
	public void i_should_get_the_correct_string_output(String output) throws InterruptedException {
			
		assertEquals(output, output);
		Thread.sleep(3000); //V�nta i 3sek
	}
	

	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000); //V�nta i 3sek
		driver.quit(); // st�nga ner chrome
	}
}