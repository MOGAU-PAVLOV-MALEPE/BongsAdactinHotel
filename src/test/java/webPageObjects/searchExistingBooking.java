package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class searchExistingBooking {
    protected WebDriver driver;

    public searchExistingBooking(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "/html/body/table[2]/tbody/tr[1]/td[2]/a[2]")
    public WebElement searchItineraryLink;
    @FindBy(xpath = "//*[@id=\"order_id_text\"]")
    public WebElement orderSearchBox;
    @FindBy(xpath = "//*[@id=\"search_hotel_id\"]")
    public WebElement goButton;
    @FindBy(xpath = "//*[@id=\"booked_form\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
    public WebElement tableFirstRow;

}
