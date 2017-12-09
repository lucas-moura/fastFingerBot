package br.edu.iftm.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDrivers {
	public static final int CHROME = 1;
	public static final int FIREFOX = 2;
	public static final int INTERNET_EXPLORER = 3;
	
	public static WebDriver getWebDriver(int type)
	{
		switch(type)
		{
			case CHROME:
				return getChromeDriver();
			case FIREFOX:
				return getFirefoxDriver();
			case INTERNET_EXPLORER:
				return getInternetExplorerDriver();
			default:
				return getChromeDriver();
		}
	}
	
	private static WebDriver getChromeDriver()
	{
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		return chromeDriver;
	}
	
	private static WebDriver getFirefoxDriver()
	{
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().window().maximize();
		return firefoxDriver;
	}
	
	private static WebDriver getInternetExplorerDriver()
	{
		InternetExplorerDriver ieDriver = new InternetExplorerDriver();
		ieDriver.manage().window().maximize();
		return ieDriver;
	}
}
