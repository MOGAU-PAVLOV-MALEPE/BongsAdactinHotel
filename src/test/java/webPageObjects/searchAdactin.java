package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class searchAdactin {
    protected WebDriver driver;
    public searchAdactin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"location\"]")
    public WebElement location;
    @FindBy(xpath = "//*[@id=\"hotels\"]")
    public WebElement hotels;
    @FindBy(xpath = "//*[@id=\"room_type\"]")
    public WebElement roomTypes;
    @FindBy(xpath = "//*[@id=\"room_nos\"]")
    public WebElement noOfRooms;
    @FindBy(xpath = "//*[@id=\"datepick_in\"]")
    public WebElement checkInDate;
    @FindBy(xpath = "//*[@id=\"datepick_out\"]")
    public WebElement checkOutDate;
    @FindBy(xpath = "//*[@id=\"adult_room\"]")
    public WebElement adultsPerRoom;
    @FindBy(xpath = "//*[@id=\"child_room\"]")
    public WebElement childrenPerRoom;
    @FindBy(xpath = "//*[@id=\"Submit\"]")
    public WebElement searchButton;

    // validation xpath
    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueBtn;

}
