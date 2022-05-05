#Author: Nayan.Thakor:thakor_nayan@yahoo.com

Feature: Register to the application with valid details in browser

	@Registration
  Scenario Outline: Check if user is able to register with valid data into application successfully
    Given user is on Registration page
    When user enters "<username>", "<email>" and "<password>"
    And click on Create Account button
    Then verify that user is successfully able to create account "<username>"
    
    Examples: 
      | username   |email								|password|
      | Automation |automation@demo.com	|Test@123|

