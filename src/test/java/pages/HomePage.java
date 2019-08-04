package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.WebDriverWrapper;

/**
 * The Class HomePage.
 */
public class HomePage extends LoadableComponent<HomePage> {

	/** The btn to the menu. */
	@FindBy(xpath = "//ul/li[1]/a")
	WebElement btnToTheMenu;

	/** The lbl banner. */
	@FindBy(xpath = "//div[@role='banner']")
	WebElement lblBanner;

	/** The btn accept cookies. */
	@FindBy(xpath = "//button[@class='agree-cookie']")
	WebElement btnAcceptCookies;

	/** The driver. */
	private WebDriver driver;

	/** The wrapper. */
	private WebDriverWrapper wrapper;

	/** The time out in seconds. */
	private final int timeOutInSeconds = 10;

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver
	 *            the driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wrapper = new WebDriverWrapper(driver);
		acceptCookies();
	}

	/*
	 * 
	 * @see org.openqa.selenium.support.ui.LoadableComponent#isLoaded()
	 */
	@Override
	protected void isLoaded() throws Error {
		wrapper.waitForElementToVisible(lblBanner, timeOutInSeconds);
		lblBanner.isDisplayed();
	}

	/*
	 * @see org.openqa.selenium.support.ui.LoadableComponent#load()
	 */
	@Override
	protected void load() {
		wrapper.waitForElementToVisible(lblBanner, timeOutInSeconds);
		lblBanner.isDisplayed();
	}

	/**
	 * Click on menu.
	 *
	 * @return the menu page
	 */
	public MenuPage clickOnMenu() {
		btnToTheMenu.click();
		return new MenuPage(driver).get();
	}

	/**
	 * Accept cookies.
	 */
	public void acceptCookies() {
		try {
			if (btnAcceptCookies.isDisplayed()) {
				btnAcceptCookies.click();
			}
		} catch (Exception ex) {
			System.out.println("Warning: Cookies pop up no found...");
		}
	}
}