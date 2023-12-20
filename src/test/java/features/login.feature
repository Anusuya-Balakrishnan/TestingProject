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

Feature: testing login page of practice website

  Scenario Outline: testing login page with different set of data
    Given I first navigate to website
    When I enter user name as "<username>"
    And enter password as "<password>"
    And I click login button
    Then I will get message success message
    
    Examples: 
      
      |username|password| 
      
      |practice	|SuperSecretPassword!	| 
      
      |practice	|SuperSecret	| 
      |username1|password1|
