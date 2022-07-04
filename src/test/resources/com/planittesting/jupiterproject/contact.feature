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
#Sample Feature Definition Tplate
@contact @regression
Feature: Contact Page Feature
This feature file is used to test contact page
     
    @Regression
    Scenario: Validate error and success message in contact page
    Given Navigate to contact page
    When click on submit button
    And I should get error messages "We welcome your feedback - but we won't get it unless you complete the form correctly."
    And Populate values "Testing1" "Testing2" "auto@gmail.com" "014589" "welcome"
    When click on submit button
    Then I should not get error messages "We welcome your feedback - but we won't get it unless you complete the form correctly."
         
   #@Smoke 
   #Scenario Outline: Verifying the stability of the system
   #Given Navigate to contact page
   #And Populate values "<forename>" "<sname>" "<email>" "<phone>" "<message>"
   #When click on submit button
   #Then I should get successfull messages "<successmessage>"
    #
  #Examples:
  #
  #|forename|sname|email|phone|message|successmessage|
  #|Test1|Auto1|test1@gmail.com|042899|thanks|we appreciate your feedback|
  #|Test2|Auto2|test2@gmail.com|043829|thanks|we appreciate your feedback|
  #|Test3|Auto3|test3@gmail.com|041849|thanks|we appreciate your feedback|
  #|Test4|Auto4|test4@gmail.com|041129|thanks|we appreciate your feedback|
  #|Test5|Auto5|test5@gmail.com|041999|thanks|we appreciate your feedback|
  
  

 
 
  
  
  
     
     