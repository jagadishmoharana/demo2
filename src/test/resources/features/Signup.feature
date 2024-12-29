Feature: Sign up

Scenario: Sign up with valid credentials
  Given User is on the Sign up page
  When User enter valid username "Jagadis" into Username field
  And User enter valid password "jagadish@123" into Password field
  And User clicks signup
  Then User should successfully signup and "Sign up successful." should be display
  
Scenario: Sign up with invalid credentials
  Given User is on the Sign up page
  When User enter valid username "Jagadish" into Username field
  And User enter invalid password "jagadish@123" into Password field
  And User clicks signup
  Then User should not able to signup and get an message "This user already exist."
  
Scenario: Sign up with invalid credentials
  Given User is on the Sign up page
  When User leave Username field as blank
  And User leave Password field as blank
  And User clicks signup
  Then User should get "Please fill out Username and Password." and not able to signup