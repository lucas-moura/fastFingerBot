package br.edu.iftm.fastfingerbot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.edu.iftm.selenium.SeleniumConfigs;
import br.edu.iftm.selenium.SeleniumDrivers;

public class FastFingerBot {
	private final String URL_LOGIN = "https://10fastfingers.com/login";
	private final String URL_PLAY = "https://10fastfingers.com/typing-test/portuguese";
	private WebDriver driver;
	private WebDriverWait driverWait;
	private String user, password;
	
	/**
	 * Initialize the FastFingerBot
	 * @param driver The Selenium WebDriver
	 * @param user The site username (or email)
	 * @param password The site password
	 */
	public FastFingerBot(int webDriverId, String user, String password)
	{
		SeleniumConfigs.initialize();
		this.driver = SeleniumDrivers.getWebDriver(webDriverId);
		this.driverWait = new WebDriverWait(driver, 10);
		this.user = user;
		this.password = password;
	}
	
	/**
	 * Initialize the FastFingerBot
	 * @param user The site username (or email)
	 * @param password The site password
	 */
	public FastFingerBot(String user, String password)
	{
		SeleniumConfigs.initialize();
		this.driver = SeleniumDrivers.getWebDriver(SeleniumDrivers.CHROME);
		this.driverWait = new WebDriverWait(driver, 10);
		this.user = user;
		this.password = password;
	}
	
	/**
	 * Make the login
	 */
	private void login()
	{
		driver.navigate().to(URL_LOGIN);
		By nameBtUsername = By.name("data[User][username]");
		By nameBtPassword = By.name("data[User][password]");
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(nameBtUsername));
		
		// To write the user credentials
		driver.findElement(nameBtUsername).sendKeys(this.user);
		driver.findElement(nameBtPassword).sendKeys(this.password);
		
		// Send
		driver.findElement(By.id("login-form-submit")).click();
	}
	
	/**
	 * Normalize velocit in range 20-100
	 * @param velocity
	 * @return
	 */
	private int normalizeVelocity(int velocity)
	{
		velocity = 100 - velocity;
		if(velocity <= 0)
			velocity = 20;
		else if(velocity >= 100)
			velocity = 100;
		return velocity;
	}
	
	/**
	 * Play the 10FastFinger Game
	 * @param speed The type speed in range 20-100 (max)
	 */
	private void play(int speed)
	{
		speed = normalizeVelocity(speed);
		driver.navigate().to(URL_PLAY);
		String timeLeft = null;
		WebElement timerElement = driver.findElement(By.xpath("//*[@id='timer']"));
		do
		{
			String word = driver.findElement(By.className("highlight")).getText();
			typeWord(word, speed);
			timeLeft = timerElement.getText();
		}while(haveTime(timeLeft));
	}
	
	/**
	 * Type the word with delay (100 - speed)
	 * @param word
	 * @param speed
	 */
	private void typeWord(String word, int speed)
	{
		WebElement textField = driver.findElement(By.id("inputfield"));
		for (char letter : word.toCharArray())
		{
			textField.sendKeys(String.valueOf(letter));
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e)
			{
				System.out.println(e);
			}
		}
		textField.sendKeys(Keys.SPACE);
	}
	
	
	private boolean haveTime(String timeTxt)
	{
		return !timeTxt.equals("0:00");
	}
	
	/**
	 * Play the 10FastFinger Game
	 * @param speedPerc The typing speed percentage.
	 */
	public void start(int speedPerc)
	{
		this.login();
		this.play(speedPerc);
	}
	
	
}
