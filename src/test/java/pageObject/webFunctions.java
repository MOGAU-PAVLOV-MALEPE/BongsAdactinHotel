package pageObject;

import org.openqa.selenium.WebDriver;
import webPageObjects.*;
import webUtilities.generateFile;
import webUtilities.webActions;
import webUtilities.webUtilities;

public class webFunctions extends webActions {
    public webUtilities web = new webUtilities();
    confirmBooking bookNowObj;
    searchExistingBooking existingBooking;
    generateFile generateFile = new generateFile();
    deleteBooking dltBooking;

    //Login
    public void Login(WebDriver driver, String username, String password) {
        login loginObject = new login(driver);

        try {
            sendKeysObject(loginObject.txtUsernme,driver,username);
            sendKeysObject(loginObject.txtPassword,driver,password);
            clickObject(loginObject.btnLogin, driver);
        } catch (Exception e) {
            System.out.println("Login was Unsuccessful,Error: " + e.getMessage());

        } // end catch

    }// end login method

    //Validation
    public void loginSuccessful(WebDriver driver){
        login loginObject = new login(driver);

        if(loginObject.txtWelcomeMessage.isDisplayed()){
            System.out.println("Login was Successful");
        }else{
            System.out.println("Login was Unsuccessful");
        }
    }
    //Search

    public void search(WebDriver driver, String location, String hotels, String RoomType, String NumberOfRooms, String CheckInDate, String CheckOutDate, String AdultsPerRoom,String ChildrenPerRoom) {
        searchAdactin searchObj = new searchAdactin(driver);
        try{
            selectObject(searchObj.location, driver,"visibletext",location);
            selectObject(searchObj.hotels, driver,"visibletext",hotels);
            selectObject(searchObj.roomTypes, driver,"visibletext",RoomType);
            selectObject(searchObj.noOfRooms, driver,"visibletext",NumberOfRooms);
            sendKeysObject(searchObj.checkInDate,driver,CheckInDate);
            sendKeysObject(searchObj.checkOutDate,driver,CheckOutDate);
            selectObject(searchObj.adultsPerRoom, driver,"visibletext",AdultsPerRoom);
            selectObject(searchObj.childrenPerRoom, driver,"visibletext",ChildrenPerRoom);
            clickObject(searchObj.searchButton, driver);


        }catch(Exception e){
            System.out.print("search unsuccessful : " + e.getMessage());

        }

    }
    // validation method
    public void searchHotel(WebDriver driver){
        searchAdactin searchObj = new searchAdactin(driver);
        if (searchObj.continueBtn.isDisplayed()) {
            System.out.println("Hotel search was Successful");
        } else {
            System.out.println("Hotel Search was Unsuccessful");
        }
    }

    //Select

    public void select(WebDriver driver){
        selectAdactin selectObj = new selectAdactin(driver);
        try{
            clickObject(selectObj.radioButton, driver);
            clickObject(selectObj.continueButton, driver);

        }catch(Exception e){
            System.out.print(" Error : " + e.getMessage());

        }
    }// end select Method

    //validation method(select)
    public void selectHotel( WebDriver driver) {
        selectAdactin selectObj = new selectAdactin(driver);
        if(selectObj.txtbookHotel.isDisplayed()){
            System.out.println("Hotel selected successfully");
        }else{
            System.out.println("Hotel was not selected");
        }
    }

    //finalize booking

    public void bookNow(WebDriver driver,String FirstName, String LastName,String BillingAddress,String CreditCardNumber,String CreditCardType,String ExpiryDateMonth,String ExpiryDateYear,String CVV){

         bookNowObj = new confirmBooking(driver);
        try{
            sendKeysObject(bookNowObj.firstName,driver,FirstName);
            sendKeysObject(bookNowObj.lastName,driver,LastName);
            sendKeysObject(bookNowObj.billingAddress,driver,BillingAddress);
            sendKeysObject(bookNowObj.creditCardNo,driver,CreditCardNumber);

            selectObject(bookNowObj.creditCardType, driver,"visibletext",CreditCardType);
            selectObject(bookNowObj.ccExpiryMonth, driver,"visibletext",ExpiryDateMonth);
            selectObject(bookNowObj.ccExpiryYear, driver,"visibletext",ExpiryDateYear);

            sendKeysObject(bookNowObj.cvvNumber,driver,CVV);
            clickObject(bookNowObj.bookNowButton, driver);

        }catch(Exception e){
            System.out.print("Booking unsuccessful " + e.getMessage());
        }
    }//end bookNow method

    //validation
    public void orderNumGenerated(WebDriver driver){
         bookNowObj = new confirmBooking(driver);
        String OrderNum = bookNowObj.OrderNumber.getAttribute("value");
        if(bookNowObj.OrderNumber.isDisplayed()){
            generateFile.writeToFile(OrderNum);
            System.out.println("Hotel was booked successful,OrderNumber:"+ OrderNum);
        }else {
            System.out.println("Order NUmber was not generated");
        }

    }

    public void logout(WebDriver driver) throws Exception {

        logout logoutObj = new logout(driver);
        Thread.sleep(5000);
        try {

            clickObject(logoutObj.logoutButton, driver);
            clickObject(logoutObj.ClickToLoginAgain,driver);

        } catch (Exception e) {
            System.out.print("Logout unsuccessful " + e.getMessage());

        }
    }//end logoutMethod

    //Validation method
    public void logoutSuccessful(WebDriver driver)throws Exception{
        logout logoutObj = new logout(driver);
        if(logoutObj.ClickToLoginAgain.isDisplayed()){
            System.out.println("Logout was Successful");
        }else{
            System.out.println("Logout was Unsuccessful");
        }

        Thread.sleep(5000);
        web.getWebDriver().quit();
    }


    //navigate to the itinerary page
    public void navigateToBookedItinerary(WebDriver driver){
        existingBooking = new searchExistingBooking(driver);
        try{
            clickObject(existingBooking.searchItineraryLink,driver);
        }catch(Exception e){
            System.out.println("Could not navigate to booked itinerary successfully" + e.getMessage());
        }
    }

    // Search for existing booking
    public void searchExistingBooking(WebDriver driver){
        existingBooking = new searchExistingBooking(driver);
        generateFile = new generateFile();

        String theOderNumber = generateFile.readFromFile();
        try{
            sendKeysObject(existingBooking.orderSearchBox,driver,theOderNumber);
            clickObject(existingBooking.goButton,driver);

        }catch (Exception e){
            System.out.println("Could not search successfully" + e.getMessage());
        }
    }

    // validation Confirm existing booking
    public void confirmExistingBooking(WebDriver driver){
        existingBooking = new searchExistingBooking(driver);
        if (existingBooking.tableFirstRow.isDisplayed()){
            System.out.println("Existing booking matches the provided orderNumber searched successfully");
        }else {
            System.out.println("Search unsuccessful");
        }
    }

    public void deleteExistingBooking(WebDriver driver){
        dltBooking = new deleteBooking(driver);
        try {
            clickObject(dltBooking.selectOrderButton,driver);
            clickObject(dltBooking.cancelSelectedButton,driver);
            driver.switchTo().alert().accept();
        }catch (Exception e){
            System.out.println("Could not delete Booking" + e.getMessage());
        }

    }

    // validation Confirm Delete
    public void confirmDelete(){
        try {
            if (dltBooking.search_result_error.isDisplayed()){
                System.out.println("Booking delete successfully");
            }else{
                System.out.println("Booking not deleted");
            }

        }catch (Exception e){
            System.out.println("Could not delete Booking" + e.getMessage());
        }
    }
}
