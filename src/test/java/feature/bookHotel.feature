
Feature: Book a Hotel

  Background:  User book and delete Hotel
    Given a user launch browser and navigate the Adactin web page
    When a user enter username and password and clicks login
    Then a user login successfully and a search page is opened successfully
  @run1
  Scenario: Successful booking of a hotel
    And a user populates fields in the search page and clicks continue
    Then a user is navigated to the select page successfully

    And a user selects a hotel from the selection page and click continue
    Then a booking confirmation page is opened successfully

    And a user populates the book with valid data and clicks confirm
    Then a order is generated and the booking is successful

    When a user click logout
    Then a user is logged out of the app successfully

  @run2
  Scenario: Delete booking

    And a user clicks on the search itinerary link

    And a user enters an order number into the input field and clicks the go button
    Then a booking record is displayed on the table

    When a booking record is displayed on the table,the user selects it and deletes it
    And a user searches the record again using the order number
    Then the record is not displayed

    And a user click logout
    Then a user is logged out of the app successfully