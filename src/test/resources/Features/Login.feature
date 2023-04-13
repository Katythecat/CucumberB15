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

  @scenarioOutline
  #Parameterize/ Data Driven
  Scenario Outline: Login with multiple credential using Scenario Outline
    #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser
    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |
  # Ctrl alt l to adjust the space

  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |














  #Hooks: For defining pre and post steps in any Cucumber framework
  #     : This is always created inside StepDefinitions folder
  #     : Hooks will take care of pre and post conditions irrespective of
  #

  #Background : Its the clubbing of common steps in different scenarios of a
  #            feature file till flow is not broken

  #we can
  #1. Hard code -- > java
  #2. Config file --> java
  #3. regular expression --> cucumber itself provides multiple option through which we can
      #feed data from feature file into stp definition
      # put the data in double quotes " "

    #here hash use for comment
  #given is precondition
  #When is action
  #Then validate
  #1 feature file can have multiple scenario

  #for cucumber itself we can
    #-Parameterize by using double quotes
    #-and Using Data Driven Testing
        # Data driven testing using Scenario Outline with Example keyword
        # Data driven testing using Cucumber DataTable --> will implement with list of map