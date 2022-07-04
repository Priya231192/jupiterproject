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
@Regression
Feature: Adding toys to cart
I want to add items and validate total value

  @Regression
  Scenario: Adding product to cart
    Given User is on shop page
    When Add stuffed frog 2
    And Add fluppy bunny 3
    And Add valentine bear 5
    Then click cart to check value
    And Subtotal validation for products "Stuffed Frog" 10.99 2
    And Subtotal validation for products "Fluffy Bunny" 9.99 3
    And Subtotal validation for products "Valentine Bear" 14.99 5
    Then Final amount verification
    
    
    