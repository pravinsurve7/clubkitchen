package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Browser objects.
 */
public class BrowserFactory {

	/** The driver. */
	static WebDriver driver;

	/** The Constant CHROME_EXE_PATH. */
	private static final String CHROME_EXE_PATH = "/libs/chromedriver.exe";

	/**
	 * Gets the driver.
	 *
	 * @param browser
	 *            the browser
	 * @return the driver
	 */
	public static WebDriver getDriver(String browser) {
		DesiredCapabilities capability = new DesiredCapabilities();
		if ("CHROME".equalsIgnoreCase(browser)) {
			String chromePath = System.getProperty("user.dir") + CHROME_EXE_PATH;
			System.setProperty("webdriver.chrome.driver", chromePath);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-bundled-ppapi-flash");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-web-security");
			options.addArguments("--always-authorize-plugins");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--test-type");
			options.addArguments("--enable-npapi");
			options.addArguments("--disable-extensions");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");

			capability = DesiredCapabilities.chrome();
			capability.setJavascriptEnabled(true);
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

			driver = new ChromeDriver(capability);
		} else {
			try {
				throw new Exception("Browser not defined...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
