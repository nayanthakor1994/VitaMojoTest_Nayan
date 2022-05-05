#Author: Nayan.Thakor:thakor_nayan@yahoo.com

Feature: Register to the application with valid details in API

	@RegistrationApi
  Scenario Outline: Check if user is able to register with valid data into application api successfully
    Given user has registration api url "<url>"
    When create new user with "<username>", "<email>" and "<password>" and verify response <statuscode>
		And verify registered "<username>"
    
    Examples: 
      | username   	|email								  |password|url													|statuscode|
      | Automation  |automation@demo.com	|Test@123|https://vmos2.vmos-demo.com |201|
    
