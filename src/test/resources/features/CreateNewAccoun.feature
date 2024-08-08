 @Regression
 Feature: Create new account functionality
 Background:Setup create account scenarios
  #Steps that are common between Scenarios of specific feature
    #Background steps will execute at beginning of each scenario
    #Hooks execute first than background will be executed
    #Background is optional
 Given user click on "Sign in" link
 Then validate user is in sign in page
 Given user click on "Create New Account" linkFea


  Scenario: create valid account with random email
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link
    When user enter "Mushtari" and "random"  and "Romin0421!"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match
@UserStory1
  Scenario: Create account with existing email
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link
    When user enter "Mushtari" and "angle@gmail.com"  and "Romin0421!"
    When user click on "Sign Up" button
    Then user should see error "this email is already exist, please use another email address"