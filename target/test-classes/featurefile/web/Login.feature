#Author: Nayan.Thakor:thakor_nayan@yahoo.com

Feature: Login to the application with valid credentials in browser

  @Login
  Scenario Outline: Check if user is logged into application successfully
    Given Redirected to login page
    And User is on login page
    When user enters "<email>" and "<password>"
    And user clicked on login button
    Then user is navigated to the home page "<username>"
    
    Examples: 
      | username   |email								|password|
      | Automation |automation@demo.com	|Test@123|

