package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.WebDriverWrapper;

/**
 * The Class MenuPage.
 */
public class MenuPage extends LoadableComponent<MenuPage> {

	/** The icon backet. */
	@FindBy(xpath = "//i[@class='icon--basket']")
	WebElement iconBacket;

	/** The txt address. */
	@FindBy(xpath = "//input[@id='address-input']")
	WebElement txtAddress;

	/** The btn pop up to the menu. */
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnPopUpToTheMenu;

	/** The menus. */
	@FindBy(xpath = "//ul[@role='menubar' and @itemscope]")
	List<WebElement> menus;

	/** The menu quesadillas. */
	@FindBy(xpath = "//div[@title='Quesadillas']")
	WebElement menuQuesadillas;

	/** The menuburritos. */
	@FindBy(xpath = "//div[@title='burritos']")
	WebElement menuburritos;

	/** The menu burritobowls. */
	@FindBy(xpath = "//div[@title='Burrito bowls']")
	WebElement menuBurritobowls;

	/** The menu sidedishes and nachos. */
	@FindBy(xpath = "//div[@title='Side dishes & nachos']")
	WebElement menuSidedishesAndNachos;

	/** The menu desserts. */
	@FindBy(xpath = "//div[@title='desserts']")
	WebElement menuDesserts;

	/** The add on jalapenos. */
	@FindBy(xpath = "//fieldset/ul/li[1]/label")
	WebElement addOnJalapenos;

	/** The add on cheese. */
	@FindBy(xpath = "//fieldset/ul/li[2]/label")
	WebElement addOnCheese;

	/** The add on cream dip. */
	@FindBy(xpath = "//fieldset/ul/li[3]/label")
	WebElement addOnCreamDip;

	/** The btn add on add to cart. */
	@FindBy(xpath = "//button[@id='topup-modal--close']")
	WebElement btnAddOnAddToCart;

	/** The msg item added successfully. */
	@FindBy(xpath = "//div[@class='alert is--success is--rounded']")
	WebElement msgItemAddedSuccessfully;

	/** The verify cart item. */
	@FindBy(xpath = "//div[@class='cart--item']")
	WebElement verifyCartItem;

	/** The driver. */
	private WebDriver driver;

	/** The wrapper. */
	private WebDriverWrapper wrapper;

	/** The time out in seconds. */
	private final int timeOutInSeconds = 10;

	/**
	 * Instantiates a new menu page.
	 *
	 * @param driver
	 *            the driver
	 */
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wrapper = new WebDriverWrapper(driver);
	}

	/*
	 * @see org.openqa.selenium.support.ui.LoadableComponent#isLoaded()
	 */
	@Override
	protected void isLoaded() throws Error {
		wrapper.waitForElementToVisible(txtAddress, timeOutInSeconds);
		txtAddress.isDisplayed();
	}

	/*
	 * @see org.openqa.selenium.support.ui.LoadableComponent#load()
	 */
	@Override
	protected void load() {
		wrapper.waitForElementToVisible(iconBacket, timeOutInSeconds);
		iconBacket.isDisplayed();
	}

	/**
	 * Enter address.
	 *
	 * @param address
	 *            the address
	 */
	public void enterAddress(String address) {
		wrapper.waitForElementToVisible(txtAddress, 3);
		if (txtAddress.isDisplayed()) {
			txtAddress.sendKeys(address);
			btnPopUpToTheMenu.click();
		}
	}

	/**
	 * Select type from menu.
	 *
	 * @param menu
	 *            the menu
	 */
	public void selectTypeFromMenu(String menu) {
		String url = driver.getCurrentUrl();
		while (url.contains("wallenstein")) {
			url = driver.getCurrentUrl();
		}
		switch (menu.toUpperCase()) {
		case "QUESADILLAS":
			menuQuesadillas.click();
			break;
		case "BURRITOS":
			menuburritos.click();
			break;
		case "BURRITO BOWLS":
			menuBurritobowls.click();
			break;
		case "SIDE DISHES & NACHOS":
			menuSidedishesAndNachos.click();
			break;
		case "DESSERTS":
			menuDesserts.click();
			break;
		default:
			break;
		}
		wrapper.wait(2000);
	}

	/**
	 * Adds the items to cart.
	 *
	 * @param itemName
	 *            the item name
	 */
	public void addItemsToCart(String itemName) {
		WebElement element = driver.findElement(By.xpath("//a[@title='" + itemName + "']/../../div/form/button"));
		wrapper.waitForElementToBeClickable(element, timeOutInSeconds);
		element.click();
	}

	/**
	 * Choose add on.
	 *
	 * @param addOnName
	 *            the add on name
	 */
	public void chooseAddOn(String addOnName) {
		wrapper.waitForElementToVisible(addOnJalapenos, timeOutInSeconds);
		switch (addOnName.toUpperCase()) {
		case "JALAPENOS":
			addOnJalapenos.click();
			break;
		case "CHEESE":
			addOnCheese.click();
			break;
		case "CREAM DIP":
			addOnCreamDip.click();
			break;
		default:
			break;
		}
	}

	/**
	 * Click add to cart on add on.
	 */
	public void clickAddToCartOnAddOn() {
		btnAddOnAddToCart.click();
		wrapper.waitForElementToVisible(msgItemAddedSuccessfully, 5);
	}

	/**
	 * Verify cart item.
	 *
	 * @return true, if successful
	 */
	public boolean verifyCartItem() {
		return verifyCartItem.isDisplayed();
	}
}