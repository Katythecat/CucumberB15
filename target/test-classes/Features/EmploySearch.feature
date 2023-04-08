Feature: Employee search
  @smoke
  Scenario: Search employee by Id
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    When user enters valid employee id
    And clicks on search button
    And user see employee information is displayed
    #And Close the browser

    @smoke
  Scenario: Search employee by Job Title
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    When user select job title
    And clicks on search button
    And user see employee information is displayed
    #And Close the browser


