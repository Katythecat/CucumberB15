Feature: Login Functionalities
  @testcase1
  Scenario: Valid Admin login
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    And Close the browser

    #here hash use for comment
  #given is precondition
  #When is action
  #Then validate
  #1 feature file can have multiple scenario