package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class deleteBooking {
    protected WebDriver driver;

    public deleteBooking(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"check_all\"]")
    public WebElement selectOrderButton;
    @FindBy(xpath = "//*[@id=\"booked_form\"]/table/tbody/tr[3]/td/input[1]")
    public WebElement cancelSelectedButton;
    @FindBy(xpath = "//*[@id=\"search_result_error\"]")
    public WebElement search_result_error;
}
