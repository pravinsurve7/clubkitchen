package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MenuPage;
import utils.BrowserFactory;

public class AddToCartTest {

	WebDriver driver;
	HomePage homePage;
	MenuPage menuPage;

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void beforeMethod(String browser, String url) {
		driver = BrowserFactory.getDriver(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
	}

	@Test(groups = "add to cart", description = "Verify Add to Cart functoinality")
	public void addToCartTest() {
		// Navigate to Menu Page
		menuPage = homePage.clickOnMenu();

		// Enter the address
		menuPage.enterAddress("Semperstraße 44, 1180 Wien, Austria");

		// Select the type of order
		menuPage.selectTypeFromMenu("QUESADILLAS");

		// Select the item from Menu
		menuPage.addItemsToCart("Avocado Crush Quesadilla");

		// Choose Add-on
		menuPage.chooseAddOn("JALAPENOS");

		// Click on Add To Cart button after selection
		menuPage.clickAddToCartOnAddOn();

		// Verify if item is added to cart
		assertEquals(menuPage.verifyCartItem(), true);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
