package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_Headless {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			// Browser Option : selenium 3.xx trở lên
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			// Browser Option : selenium 3.xx trở lên
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("coccoc")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("brave")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		return driver;
	}
}
