package br.edu.iftm.selenium;

public class SeleniumConfigs {
	private static final String DRIVERS_DIR = "selenium_drivers/";
	
	
	/**
	 * Define o diretório dos drivers dos navegadores(Chrome, Firefox e Internet Explorer)
	 * para o WebDriver do Selenium.
	 */
	public static final void initialize()
	{
		System.setProperty("webdriver.chrome.driver", DRIVERS_DIR + "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", DRIVERS_DIR + "geckodriver.exe");
		System.setProperty("webdriver.ie.driver", DRIVERS_DIR + "IEDriverServer.exe");
	}
	
}
