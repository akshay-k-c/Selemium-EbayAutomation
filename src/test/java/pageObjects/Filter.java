package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filter {
	public WebDriver fdriver;

	// Constuctor of Filter class with remote driver parameter assigning
	// that with current driver
	public Filter(WebDriver rdriver) {
		fdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// locate all elemnts used by this class using By class
	By ScreenSize = By.xpath("//*[@id=\"c3-mainPanel-Screen%20Size\"]");
	By Model = By.xpath("//*[@id=\"refineOverlay\"]/div[2]");
	By InnerModel = By.xpath("//*[@id=\"c3-subPanel\"]/fieldset");
	By Price = By.xpath("//*[@id=\"c3-mainPanel-price\"]");
	By Input1 = By.xpath("//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[1]/div/input");
	By Input2 = By.xpath("//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[2]/div/input");
	By Location = By.xpath("//*[@id=\"c3-mainPanel-location\"]");
	By Filter = By.xpath("//*[@id=\"x-overlay__form\"]/div[3]/div[2]/button");
	By ChildTick = By.xpath("//*[@id=\"c11-mainPanel-price\"]/svg/use");
	By ViewFilter = By.xpath("//*[@id=\"s0-27_1-9-0-1[0]-0-0-6-5-4[0]-flyout\"]/button");

	// this method used for screen size filter element
	// that will open a checkbox for selecting screen size required
	public void screenSizeFilter() {
		// wait for identify the modal dialogue element present or not
		// wait for 10 seconds to identify the modal element

		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(Model));
		// Switch the driver control to founded modal
		fdriver.switchTo().activeElement();
		// Perform click operation on the element in the modal dialogue
		WebElement screenSize = modal.findElement(ScreenSize);
		screenSize.click();
		// switch back to default content
		fdriver.switchTo().defaultContent();
	}

	// this method used for apply screen size filter
	// by clicking on required checkbox
	public void applyscreenSizeFilter(double first, double second) {
		// wait for identify the inner modal dialogue element present or not
		// wait for 10 seconds to identify the modal element

		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(InnerModel));
		// Switch the driver control to founded modal
		fdriver.switchTo().activeElement();
		// Perform click operation on the element in the modal dialogue
		WebElement screenFilter = modal.findElement(
				By.xpath("//*[@id=\"c3-subPanel-Screen%20Size_" + first + "%20-%20" + second + "%20in_cbx\"]"));
		screenFilter.click();
		// switch back to default content
		fdriver.switchTo().defaultContent();

	}
	// this method used for price filter element
	// that will open 2 field for selecting price range

	public void priceFilter() {
		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(Model));
		fdriver.switchTo().activeElement();
		WebElement price = modal.findElement(Price);
		price.click();
		fdriver.switchTo().defaultContent();

	}

	// This method will send required price value in fields

	public void applyPriceFilter(int input1, int input2) {
		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(InnerModel));
		fdriver.switchTo().activeElement();
		WebElement priceFilter1 = modal.findElement(Input1);
		WebElement priceFilter2 = modal.findElement(Input2);
		priceFilter1.sendKeys(Integer.toString(input1));
		priceFilter2.sendKeys(Integer.toString(input2));
		fdriver.switchTo().defaultContent();

	}
	// this method used for location filter element
	// that will open a radio button for selecting location required

	public void locationFilter() {
		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(Model));
		fdriver.switchTo().activeElement();
		WebElement location = modal.findElement(Location);
		location.click();
		fdriver.switchTo().defaultContent();

	}

	// This method will select required location from using radio button
	public void applyLocationFilter(String location) {
		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(InnerModel));
		fdriver.switchTo().activeElement();
		WebElement locationFilter = modal
				.findElement(By.xpath("//*[@id=\"c3-subPanel-location_" + location + "%20Only\"]/span/span/input"));
		locationFilter.click();
		fdriver.switchTo().defaultContent();

	}

// This method will click the apply button at the bottom right of modal dialogue
	public void applyFilter() {
		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(Model));
		fdriver.switchTo().activeElement();
		WebElement filter = modal.findElement(Filter);
		filter.click();
		// fdriver.switchTo().defaultContent();

	}

	// for validation purpose clicking applied filters
	public void viewFilters() {

		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s0-27_1-9-0-1[0]-0-0\"]/section")));
		fdriver.switchTo().activeElement();
		modal.findElement(ViewFilter).click();
		fdriver.switchTo().defaultContent();
	}
	// validate the filters

	public void validateFilters(ArrayList<String> givenFilters) {

		WebDriverWait wait = new WebDriverWait(fdriver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"s0-27_1-9-0-1[0]-0-0-6-5-4[0]-flyout\"]/div/ul")));
		fdriver.switchTo().activeElement();
		// listing the elements whose tag name has value "a" from the applied filters
		// modal

		List<WebElement> filters = modal.findElements(By.tagName("a"));
		// initilize an arraylist to store text value from these list of elements
		ArrayList<String> filterText = new ArrayList<>();
		// getting text from each element and store that to arraylist
		for (WebElement fl : filters) {

			String text = fl.getText();
			filterText.add(text);
		}
//validation part , we are comparing the filters name in an arraylist with
		// stored arraylist . We do a partial comparison of each value from input
		// arraylist with stored arraylist

		for (String str1 : givenFilters) {

			boolean partialMatch = false;
			for (String str2 : filterText) {
				if (str2.contains(str1)) {
					partialMatch = true;
					Assert.assertTrue(str2.contains(str1));
					break;
				}

			}
			Assert.assertTrue(partialMatch);
		}
	}

}
