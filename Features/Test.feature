Feature: first 

@scenario1
  Scenario: Title of your scenario
    Given user launch chrome browser
    When user open url "https://www.ebay.com/"
    And click the shopbycategory
    And click the Cellphones and accessories link
    And click the Cellphones and smartphones link
    And click seeAll and load filter option
    Then  apply screen size filter of size 4.0 to 4.4 inches 
    And apply price filter by passing price 5000 to 5500
    And apply the loaction filter for "US" country
    And apply filter button
    And Verify only  "Price" ,"Item Location" and "Screen Size" applied 
    Then close the browser
   
   
   @scenario2
    Scenario: Title of your scenario
    Given user launch chrome browser
    When user open url "https://www.ebay.com/"
    And Type "MacBook" in serach feild in the home page 
    And change the search category to "Computers/Tablets & Networking"
    Then click the search
    And Verify the first result matches with "MacBook"
    And Verify the page loads completly
    Then close the browser