package classes;

public class Configuracoes {
	public static final void inicializar()
	{
		String pasta = "C:\\Users\\everis\\Downloads\\DRIVERS\\";
		System.setProperty("webdriver.chrome.driver", pasta + "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", pasta + "geckodriver.exe");
		System.setProperty("webdriver.ie.driver", pasta + "IEDriverServer.exe");
	}
}
