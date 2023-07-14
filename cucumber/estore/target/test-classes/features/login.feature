#Author: your.email@your.domain.com
#date: 04-29-2023
#description: the feature is to validate login flow
#keyword: login,email,password
Feature: feature to validate the login flow for estore app

  Scenario: validate the login is successful with user credentials
  Given: the user is on the login page
  When: the user enters email and password in the form
  And: the user clicks on the login button
  Then: the user will be navigated to the Home page
  
  
