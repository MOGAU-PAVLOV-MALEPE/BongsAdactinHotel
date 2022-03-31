package webUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class webActions {

    //ClickMethod
    public void clickObject(WebElement element, WebDriver driver)
    {
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + "Not found");
        }
    }

    //selectMethod
    public void selectObject(WebElement selectElement, WebDriver driver,String selectBy,Object selectValue)
    {
        try
        {
            if (selectElement.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(selectElement));
                Select selc = new Select(selectElement);


                switch (selectBy.toUpperCase()){
                    case "INDEX":
                        selc.selectByIndex((Integer) selectValue);
                        break;
                    case "VISIBLETEXT":
                        selc.selectByVisibleText((String) selectValue);
                        break;
                    case "VALUE":
                        selc.selectByValue((String) selectValue);
                        break;
                }
            }
        } catch (Exception e){
            System.out.println(selectElement + "Not found");
        }
    }

    //sendKeysMethod
    public void sendKeysObject(WebElement txtbox, WebDriver driver,String data)
    {
        try
        {
            if (txtbox.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(txtbox));

                txtbox.clear();
                txtbox.sendKeys(data);
            }
        } catch (Exception e){
            System.out.println(txtbox + "Not found");
        }
    }

}// end class webActions
