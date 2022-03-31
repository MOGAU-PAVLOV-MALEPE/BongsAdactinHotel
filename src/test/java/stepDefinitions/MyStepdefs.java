package stepDefinitions;

import Data.data;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.webFunctions;
import webUtilities.webUtilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyStepdefs {
    public webUtilities web = new webUtilities();
    public webFunctions adactin = new webFunctions();
    public data dat = new data();
    ResultSet rs;
    ResultSet UP;


    @Before
    public void setUp() throws SQLException {
        rs = dat.ConnectAndQuerySql("jdbc:mysql://localhost:3306/automationtraingdb", "root", "Pavlov146", "Select * from booking");
        UP = dat.ConnectAndQuerySql("jdbc:mysql://localhost:3306/automationtraingdb", "root", "Pavlov146", "Select * from login_info");

    }


    @Given("^a user launch browser and navigate the Adactin web page$")
    public void a_user_launch_browser_and_navigate_the_Adactin_web_page() throws Throwable {
        web.setWebDriver(web.initializeWebDriver("chrome"));
        web.navigate("http://adactinhotelapp.com");
    }

    @When("^a user enter username and password and clicks login$")
    public void a_user_enter_username_and_password_and_clicks_login() throws Throwable {
        while (UP.next()) {
            adactin.Login(web.getWebDriver(), UP.getString("username"), UP.getString("password"));
            // Write code here that turns the phrase above into concrete actions
        }
    }

    @Then("^a user login successfully and a search page is opened successfully$")
    public void a_user_login_successfully_and_a_search_page_is_opened_successfully() throws Throwable {
        adactin.loginSuccessful(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^a user populates fields in the search page and clicks continue$")
    public void a_user_populates_fields_in_the_search_page_and_clicks_continue() throws Throwable {
        while (rs.next()) {
            adactin.search(web.getWebDriver(), rs.getString("location"), rs.getString("Hotels"), rs.getString("RoomType"), rs.getString("NUmberOfRooms"), rs.getString("CheckInDate"), rs.getString("CheckOutDate"), rs.getString("AdultsPerRoom"), rs.getString("ChildrenPerRoom"));
            // Write code here that turns the phrase above into concrete actions
        }
        rs.beforeFirst();
    }

    @Then("^a user is navigated to the select page successfully$")
    public void a_user_is_navigated_to_the_select_page_successfully() throws Throwable {
        adactin.searchHotel(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^a user selects a hotel from the selection page and click continue$")
    public void a_user_selects_a_hotel_from_the_selection_page_and_click_continue() throws Throwable {

        adactin.select(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^a booking confirmation page is opened successfully$")
    public void a_booking_confirmation_page_is_opened_successfully() throws Throwable {
        adactin.selectHotel(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^a user populates the book with valid data and clicks confirm$")
    public void a_user_populates_the_book_with_valid_data_and_clicks_confirm() throws Throwable {
        while (rs.next()) {
            adactin.bookNow(web.getWebDriver(), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("BillingAddress"), rs.getString("CreditCardNumber"), rs.getString("CreditCardType"), rs.getString("ExpiryDateMonth"), rs.getString("ExpiryDateYear"), rs.getString("CVVNumber"));
            // Write code here that turns the phrase above into concrete actions
        }
    }

    @Then("^a order is generated and the booking is successful$")
    public void a_order_is_generated_and_the_booking_is_successful() throws Throwable {
        adactin.orderNumGenerated(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^a user click logout$")
    public void a_user_click_logout() throws Throwable {

        adactin.logout(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^a user is logged out of the app successfully$")
    public void a_user_is_logged_out_of_the_app_successfully() throws Throwable {
        adactin.logoutSuccessful(web.getWebDriver());
        // Write code here that turns the phrase above into concrete actions

    }


    @And("^a user clicks on the search itinerary link$")
    public void aUserClicksOnTheSearchItineraryLink() {
        adactin.navigateToBookedItinerary(web.getWebDriver());
    }


    @And("^a user enters an order number into the input field and clicks the go button$")
    public void aUserEntersAnOrderNumberIntoTheInputFieldAndCliksTheGoButton() {
        adactin.searchExistingBooking(web.getWebDriver());
    }

    @Then("^a booking record is displayed on the table$")
    public void aBookingRecordIsDisplayedOnTheTable() {
        adactin.confirmExistingBooking(web.getWebDriver());
    }

    @When("^a booking record is displayed on the table,the user selects it and deletes it$")
    public void aBookingRecordIsDisplayedOnTheTableTheUserSelectsItAndDeletesIt() {
        adactin.deleteExistingBooking(web.getWebDriver());
    }

    @And("^a user searches the record again using the order number$")
    public void aUserSearchesTheRecordAgainUsingTheOrderNumber() {
        adactin.searchExistingBooking(web.getWebDriver());
    }

    @Then("^the record is not displayed$")
    public void theRecordIsNotDisplayed() {
        adactin.confirmDelete();
    }

}//end mystepDefinitions
