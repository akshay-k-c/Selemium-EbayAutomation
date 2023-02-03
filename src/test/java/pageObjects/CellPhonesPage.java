package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//pgae objects for Cell phnoes page used for for doing activities in cell phones page 
public class CellPhonesPage {
	public WebDriver cdriver;
	
	//Constuctor of cellphone class with remote driver parameter assigning 
	//that with current driver 
	public CellPhonesPage(WebDriver rdriver) {
		cdriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}

	// Locate the elements using By class
	By CellPhonesAndSmartPhone=By.linkText("Cell Phones & Smartphones");
	By SeeAll=By.xpath("//*[@id=\"mainContent\"]/div[1]/section[1]/div[1]/div[2]/button");
	
	//click method for cell phones smart phones 
	public void clickCellPhonesSmartPhone() {
		cdriver.findElement(CellPhonesAndSmartPhone).click();
	}
	//method for click seeAll arrow;
	public void clickSeeAll() {
		cdriver.findElement(SeeAll).click();
	}

}
