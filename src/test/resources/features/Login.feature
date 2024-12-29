Feature: Login

Scenario: Login with valid credentials
  Given User is on the login page
  When User enter valid username "Jagadish" into username field
  And User enter valid password "jagadish@123" into password field
  And User clicks login
  Then User should successfully login and "Welcome Jagadish" should be display
  
Scenario: Login with invalid credentials
  Given User is on the login page
  When User enter valid username "Jagadish" into username field
  And User enter invalid password "admin123" into password field
  And User clicks login
  Then User should not able to login and get an message "Wrong password."
  
Scenario: Login with invalid credentials
  Given User is on the login page
  When User enter invalid username "Jagadishs" into username field
  And User enter valid password "jagadish@123" into password field
  And User clicks login
  Then User should not able to login and get an message "User does not exist."
  
Scenario: Login with invalid credentials
  Given User is on the login page
  When User leave username field as blank
  And User leave password field as blank
  And User clicks login
  Then User should get "Please fill out Username and Password." and not able to login