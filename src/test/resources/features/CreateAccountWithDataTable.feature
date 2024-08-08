Feature: Create new account functionality
Background:Setup create account scenarios
  #Steps that are common between Scenarios of specific feature
    #Background steps will execute at beginning of each scenario
    #Hooks execute first than background will be executed
    #Background is optional
Given user click on "Sign in" link
Then validate user is in sign in page
Given user click on "Create New Account" link
@UsingMap
  Scenario: using  a Map as Data table
    When user enter new account info
    |name    |Mushtari|
    |email   | random |
    |password|"Romin0421!"|
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match
  @usingList
  Scenario: using  a List as Data table
    When user enter new account info
      |Mushtari|
      | email |
      |"Romin0421!"|
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match
    @UsingListOfList
    Scenario: using list of list
      When user enter new account as list of list
      |John | random| John|
      |Muhammad|random|Password123|
      When user click on "Sign Up" button
      Then validate user is in account page
      Then validate email address in account page match
@UsingListOfMaps
  Scenario: using list of Maps
    When user enter new account as list of list
      |Name | random| Password|
      |Muhammad|random|Password123|
      |John    |random|john123|
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match