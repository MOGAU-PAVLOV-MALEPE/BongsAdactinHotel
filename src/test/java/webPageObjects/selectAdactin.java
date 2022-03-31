package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class selectAdactin {
    protected WebDriver driver;

    public selectAdactin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"radiobutton_0\"]")
    public WebElement radioButton;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueButton;

    // validation xpath
    @FindBy(xpath = "//*[@id=\"book_hotel_form\"]/table/tbody/tr[2]/td")
    public WebElement txtbookHotel;
}
