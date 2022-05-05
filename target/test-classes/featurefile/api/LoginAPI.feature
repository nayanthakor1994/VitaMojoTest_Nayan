#Author: Nayan.Thakor:thakor_nayan@yahoo.com

Feature: Login to the application with valid credentials in API

  @LoginApi
  Scenario Outline: Check if user is able to logged into application successfully
    Given user has login api url "<url>"
    When user enters "<email>" and "<password>" to the post request and verify response <statuscode>
		And verify logged in user "<email>" and "<username>"
    
    Examples: 
      | username   	|email								|password|url													|statuscode|
      | Automation  |automation@demo.com	|Test@123|https://vmos2.vmos-demo.com |201|

