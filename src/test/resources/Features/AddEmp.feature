Feature: Employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user click on Add employee button

  @testcase2 @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user click on Add employee button
    And user enters firstname and middle and lastname
    #And user click on save button
    #And Close the browser

  @database
  Scenario: adding the employee from frontend and verifying from backend
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user click on Add employee button
    And user enter "nesha" and "sania" and "standart"
    And user captures teh employee id
    And user click on save button
    And query the information in backend
    Then verify the result from frontend and backend

