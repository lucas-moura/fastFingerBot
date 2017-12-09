package classes;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FastFingerBot {
	// http://stefanteixeira.com.br/2014/04/29/entendendo-os-tipos-de-esperas-no-selenium-webdriver/
	// http://danilotl.com.br/blog/reconhecendo-caracteres-em-imagens-com-java-e-tess4j/
	private static Random rand;
	private static void logar(WebDriver driver) throws InterruptedException
	{
		String url = "https://10fastfingers.com/login";
		driver.get(url);
		String usuario = "mouulee";
		String senha = "123456789";
		// Digitar dados usuário
		driver.findElement(By.name("data[User][username]")).sendKeys(usuario);
		driver.findElement(By.name("data[User][password]")).sendKeys(senha);
		// Enviar
		driver.findElement(By.id("login-form-submit")).click();
		
		Thread.sleep(1000);
	}
	
	private static void jogar(WebDriver driver, int velocidade) throws InterruptedException
	{
		String url = "https://10fastfingers.com/typing-test/portuguese";
		driver.get(url);
		String tempo = "";
		String palavraErrada = "moura";
		
		while(!tempo.equals("0:00"))
		{
			int valorRand = rand.nextInt(100) + 1;
			String palavra;
			
			palavra = driver.findElement(By.className("highlight")).getText();
			
			for(int i=0; i < palavra.length(); i++)
			{
				if(valorRand == 100)
				{
					driver.findElement(By.id("inputfield")).sendKeys(String.valueOf('m'));
					Thread.sleep(70);
					driver.findElement(By.id("inputfield")).sendKeys(Keys.BACK_SPACE);
					Thread.sleep(50);
					driver.findElement(By.id("inputfield")).sendKeys(String.valueOf(palavra.charAt(i)));
				}
				else if(valorRand >= 94)
					driver.findElement(By.id("inputfield")).sendKeys(String.valueOf('m'));
				else
					driver.findElement(By.id("inputfield")).sendKeys(String.valueOf(palavra.charAt(i)));
				Thread.sleep(60);
			}
			driver.findElement(By.id("inputfield")).sendKeys(" ");
			tempo = driver.findElement(By.xpath("//*[@id='timer']")).getText();
			System.out.println("Tempo = " + tempo);
		}
	}
	
	public static void main(String[] args) {
		rand = new Random();
		Configuracoes.inicializar();
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		try {
			logar(chromeDriver);
			jogar(chromeDriver, 400);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
