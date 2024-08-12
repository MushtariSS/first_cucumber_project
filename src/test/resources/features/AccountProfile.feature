Feature: Account profile feature

  Background: Login to  account and setups
    Given user click on "Sign in" link
    Then validate user is in sign in page
    When user enter "angle@gmail.com" on "Email" field
    When user enter "Romin2021!" on "Password" field
    When user click on "Login" button
    Then user should be able to see account link
    Given user click on "Account" link

  @UserStory5
  Scenario: Change Name and phone number and validate
    Then validate user is in account page
    When user enter "Mushtari" on "Name" field
    When user enter "2023233636" on "Phone Number" field
    When user click on "Update" button
    Then validate Toast Displayed
    When wait for 5 seconds
    Then validate account name is "Mushtari"
    When user enter "John" on "Name" field
    When user enter "1023022536" on "Phone Number" field
    When user click on "Update" button
    Then validate Toast Displayed
