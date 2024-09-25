@Regression
Feature: Account profile feature

  Background: Login to  account and setups
    Given user click on "Sign in" link
    Then validate user is in sign in page
    When user enter "angle-tek@gmail.com" on "Email" field
    When user enter "Tekangle123!" on "Password" field
    When user click on "Login" button
    Then user should be able to see account link
    Given user click on "Account" link

  @UserStory5
  Scenario: Change Name and phone number and validate
    Then validate user is in account page
    When user enter "Doe" on "Name" field
    When user enter "2022233456" on "Phone Number" field
    When user click on "Update" button
    Then validate Toast Displayed
    When wait for 5 seconds
    Then validate account name is "Doe"
    When user enter "John" on "Name" field
    When user enter "1023022536" on "Phone Number" field
    When user click on "Update" button
    Then validate Toast Displayed

    @UserStory6
    Scenario: Change user password and validate
      Then validate user is in account page
      When user enter "Tekangle123!" on "Previous Password" field
      When user enter "Tekangle123!!" on "New Password" field
      When user enter "Tekangle123!!" on "Confirm Password" field
      When user click on "Change Password" button
      Then validate Toast Displayed
      When wait for 6 seconds
      When user enter "Tekangle123!!" on "Previous Password" field
      When user enter "Tekangle123!" on "New Password" field
      When user enter "Tekangle123!" on "Confirm Password" field
      When user click on "Change Password" button
      Then validate Toast Displayed
      When wait for 6 seconds


