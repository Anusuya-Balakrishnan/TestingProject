#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Demo Feature
  
Background: 
	Given First user navigate to the page
  
  Scenario: Demo scenario 1
    When user enters username1
    And user enters password1
    And user clicks submit button1
    Then user gets success message1 
    
  Scenario: Demo scenario 2
    When user enters username2
    And user enters password2
    And user clicks submit button2
    Then user gets success message2 

  