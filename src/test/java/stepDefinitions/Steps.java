package stepDefinitions;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.CellPhonesPage;
import pageObjects.Filter;
import pageObjects.HomePage;

public class Steps extends BaseClass {

	// step class will contain implementation of all
	// steps in gherkin language

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/akshaykc/eclipse-workspace/EbayAutomation/Drivers/chromedriver");
		driver = new ChromeDriver();
		hp = new HomePage(driver);

	}

	@When("user open url {string}")
	public void user_open_url(String url) {

		driver.get(url);
	}

	@Then("close the browser")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@And("click the shopbycategory")
	public void click_the_shopbycategory() {
		hp.clickShopByCatagory();

	}

	@And("click the Cellphones and accessories link")
	public void click_the_cellphones_and_accessories_link() {
		hp.clickCellPhonesAndAccessories();
	}

	@And("click the Cellphones and smartphones link")
	public void click_the_cellphones_and_smartphones_link() {

		cellPage = new CellPhonesPage(driver);
		cellPage.clickCellPhonesSmartPhone();

	}

	@And("click seeAll and load filter option")
	public void click_see_all() {
		cellPage.clickSeeAll();
	}

	@Then("apply screen size filter of size {double} to {double} inches")
	public void apply_screen_size_filter_of_size_to_inches(Double first, Double second) {
		filter = new Filter(driver);
		filter.screenSizeFilter();
		filter.applyscreenSizeFilter(first, second);
	}

	@And("Type {string} in serach feild in the home page")
	public void type_in_serach_feild_in_the_home_page(String value) {
		hp.typeSearch(value);
	}

	@And("change the search category to {string}")
	public void change_the_search_category_to(String element) {
		hp.selectFromDropdown(element);
	}

	@Then("click the search")
	public void click_the_search() {
		hp.clickSearch();

	}

	@And("Verify the first result matches with {string}")
	public void verify_the_first_result_matches_with(String name) {
		hp.verifyText(name);
	}

	@And("apply price filter by passing price {int} to {int}")
	public void apply_price_filter_by_passing_price_to(Integer input1, Integer input2) {
		filter.priceFilter();
		filter.applyPriceFilter(input1, input2);
	}

	@And("apply the loaction filter for {string} country")
	public void apply_the_loaction_filter_for_country(String location) {
		filter.locationFilter();
		filter.applyLocationFilter(location);
	}

	@And("apply filter button")
	public void apply_filter_button() {
		filter.applyFilter();
	}

	@And("Verify only  {string} ,{string} and {string} applied")
	public void verify_only_and_applied(String filter1, String filter2, String filter3) {
		// store the filters for validation from test into an ArrayList
		ArrayList<String> filters = new ArrayList<>();
		filters.add(filter1);
		filters.add(filter2);
		filters.add(filter3);
		filter.viewFilters();
		filter.validateFilters(filters);
	}
	
	@And("Verify the page loads completly")
	public void verify_the_page_loads_completly() {
	   hp.verifyPageload();
	}

}
