package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	public WebDriver hdriver;

	/// Constuctor of Filter class with remote driver parameter assigning
	// that with current driver
	public HomePage(WebDriver rdriver) {
		hdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// locate all elemnts used by this class using By class

	By ShopByCatagory = By.id("gh-shop-a");
	By CellPhonesAccessories = By.linkText("Cell phones & accessories");
	By SearchField = By.id("gh-ac");
	By DropDown = By.id("gh-cat");
	By Search = By.id("gh-btn");
	By Text = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a");

	// Method for clicking shopby category element
	public void clickShopByCatagory() {
		hdriver.findElement(ShopByCatagory).click();
	}

	// Method for clicking cell phones and accessories
	public void clickCellPhonesAndAccessories() {
		hdriver.findElement(CellPhonesAccessories).click();
	}

	// Method for type search value in search field
	public void typeSearch(String value) {
		hdriver.findElement(SearchField).clear();
		hdriver.findElement(SearchField).sendKeys(value);
	}

	// Method for selecting one value from search by category dropdown
	public void selectFromDropdown(String element) {
		WebElement dp = hdriver.findElement(DropDown);
		Select dropdownList = new Select(dp);
		dropdownList.selectByVisibleText(element);
	}

	// Method for clicking search button
	public void clickSearch() {
		hdriver.findElement(Search).click();
	}

	// Method for verify text
	public void verifyText(String result) {
		String name = hdriver.findElement(Text).getText();
		Assert.assertTrue(name.contains(result));
	}

	// Method for verify the page load
	public void verifyPageload() {
		//// Javascript executor to return value
		JavascriptExecutor js = (JavascriptExecutor) hdriver;
		boolean status = js.executeScript("return document.readyState").toString().equals("complete");
		Assert.assertTrue(status);
	}

}
