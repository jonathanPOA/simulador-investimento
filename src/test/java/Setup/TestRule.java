package Setup;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertiesReader;


public class TestRule {

	protected static WebDriver driver;

	@Before
	public void beforeCenario(Scenario s){

		ChromeOptions options = new ChromeOptions();
        String headless = "FALSE";

		String pathProjeto = System.getProperty("user.dir");
		String sistemaOperacional =  System.getProperty("os.name");

		if (sistemaOperacional.toUpperCase().contains("WINDOWS")) {
			System.setProperty("webdriver.chrome.driver", pathProjeto + "/drivers/chromedriver.exe");
			System.setProperty("os.download.path", System.getProperty("user.home").replaceAll("\\\\", "/") + "/Downloads/");
		} else {
			System.setProperty("webdriver.chrome.driver", pathProjeto + "/drivers/chromedriver");
			System.setProperty("os.download.path", System.getProperty("user.home") + "/Downloads/");
		}

		if(headless.equals("TRUE")) {
			options.addArguments("headless");
			driver.manage().window().maximize();
		}
		options.addArguments("--incognito");

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();


	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void afterCenario(Scenario cenario) {
		driver.quit();
	}
}

