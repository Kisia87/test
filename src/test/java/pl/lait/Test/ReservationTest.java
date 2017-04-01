package pl.lait.Test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.PageObjects.MainPage;
import pl.lait.PageObjects.Reservation2Page;
import pl.lait.PageObjects.ReservationPage;
import pl.lait.PageObjects.SignOnPage;
import pl.lait.Setup.Init;

public class ReservationTest extends Init{
	
	protected static WebDriver driver;

	
	// @Before
	public void run() {
		driver = getDriver();
	}
	
	// @Test
	public void reservation(){
		MainPage mainPage  = new MainPage();
		SignOnPage signOn = new SignOnPage();
		ReservationPage reservPage = new ReservationPage();
		Reservation2Page reserv2page = new Reservation2Page();
		
		mainPage.link_signOn(driver).click();
		signOn.loginAs("adam_qwe123", "qwe123", driver);
		reservPage.radio_oneWay(driver);
		reservPage.selectPassengersCount(driver, "1");
		reservPage.selectDepartingFrom(driver, "Paris");
		reservPage.selectFromMonth(driver, "April");
		reservPage.selectFromDay(driver, "2");
		reservPage.selectToDay(driver, "4");
		reservPage.radioChooseClass_business(driver);
		reservPage.radioChooseClass_economy(driver);
		reservPage.radioChooseClass_first(driver);
		reservPage.selectAirLine(driver, "No Preference");
		
		printScr("reservation");
		reservPage.buttonFindFlights(driver).click();
		printScr("reservation");
		
		
		reserv2page.radio_depart2(driver).click(); //2 strona rezerwacji
		reserv2page.radio_return2(driver).click();
		
		printScr ("reservation2");
		reserv2page.button_continue(driver).click();
		printScr ("reservation2");
		
		reserv2page.fillPassNames("Dorota", "Cymerman", driver);
		reserv2page.selectPassMeal(driver).selectByVisibleText("Vegetarian");
		printScr("reservation3");
		reserv2page.selectCreditCard(driver).selectByVisibleText("Visa");
		reserv2page.input_creditnumber(driver).sendKeys("123123123");
		reserv2page.selectCCexpMonth(driver).selectByVisibleText("03");
		reserv2page.selectCCexpYear(driver).selectByVisibleText("2009");
		reserv2page.fillCreditOwner("Dorota", "właściciel", "karty", driver);
		reserv2page.chcecboxTicketLessTravel(driver).click();
		reserv2page.inputBillAddress(driver).clear();
		reserv2page.inputBillAddress(driver).sendKeys("nowy adres billAddr");
		printScr("reservation3");
		reserv2page.inputBillCity(driver).sendKeys("Lublin");
		reserv2page.buttonBuyFlights(driver).click();
		printScr("reservation3");
	}
	
	
}