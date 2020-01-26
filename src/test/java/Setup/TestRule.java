package Setup;

import Utils.PropertyReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRule {

	private static WebDriver driver;
	private static String urlSimulador;

	@Before
	public void beforeCenario(Scenario cenario){

		PropertyReader propertyReader = new PropertyReader();

		if (cenario.getSourceTagNames().contains("@UI")) {

			urlSimulador = propertyReader.getProperty("url_simulador");
			ChromeOptions options = new ChromeOptions();
			String pathProjeto = System.getProperty("user.dir");

			if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
				System.setProperty("webdriver.chrome.driver", pathProjeto + "/drivers/chromedriver.exe");
				System.setProperty("os.download.path", System.getProperty("user.home")
						.replaceAll("\\\\", "/") + "/Downloads/");
			} else {
				System.setProperty("webdriver.chrome.driver", pathProjeto + "/drivers/chromedriver");
				System.setProperty("os.download.path", System.getProperty("user.home") + "/Downloads/");
			}

			if (Boolean.parseBoolean(propertyReader.getProperty("headless"))) options.addArguments("headless");

			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();

			if (!Boolean.parseBoolean(propertyReader.getProperty("headless")))	driver.manage().window().maximize();

		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static String getUrlSimulador() {
		return urlSimulador;
	}

	@After
	public void afterCenario(Scenario cenario) {
		if (cenario.getSourceTagNames().contains("@UI")) driver.quit();
	}
}

