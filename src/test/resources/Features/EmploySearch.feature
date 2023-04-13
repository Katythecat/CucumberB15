Feature: Employee search

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search employee by Id
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid employee id
    And clicks on search button
    And user see employee information is displayed
    #And Close the browser

    @smoke1
  Scenario: Search employee by Job Title
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user select job title
    And clicks on search button
    And user see employee information is displayed
    #And Close the browser





  #Background: This is used to define all the common steps that multiple
  #             scenarios have in the same feature file ,
  #             till the time flow is not broken


  #HOOKS: For defining pre and Post steps in any Cucumber framework
    #     : This is always created inside the StepDefinitions folder
    #     : Hooks will take care of pre and post conditions irrespective
    #     : of what goes in between the test steps

    #BACKGROUND: Its the clubbing of common steps in different scenarios of a feature file
   #             till flow is not broken
   #1. Hard Code
   #2. Config file
   #-----------------Cucumber itself provides multiple option through which we can feed data from
   # feature file into Step Definition---------------------------------------------
   #3. Regular Expressions
       # put the data in double quotes [""]
  #4. Scenario Outline
      # Provide you an alternative to Data driven testing
      # Also supports parameterization


  #--Parameterization--
  # Executing the same test case with multiple data



  # If you want to use parameterization - the same test case you have multiple data
  # If you want data driven testing
    #Scenario Outline is always used along with the keyword 'Examples'




