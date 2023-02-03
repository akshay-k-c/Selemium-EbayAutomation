package stepDefinitions;

import org.openqa.selenium.WebDriver;

import pageObjects.CellPhonesPage;
import pageObjects.Filter;
import pageObjects.HomePage;

public class BaseClass {
	//this class contains variables that are frequently used 
	//by other classes like webdriver, pageObjects 
	//Step definition class will extend this base class 

	public WebDriver driver;
	public HomePage hp;
	public CellPhonesPage cellPage;
	public Filter filter;
	
}
