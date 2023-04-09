Feature: Login Functionalities
  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser













  #Hooks: For defining pre and post steps in any Cucumber framework
  #     : This is always created inside StepDefinitions folder
  #     : Hooks will take care of pre and post conditions irrespective of
  #


    #here hash use for comment
  #given is precondition
  #When is action
  #Then validate
  #1 feature file can have multiple scenario