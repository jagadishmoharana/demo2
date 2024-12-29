Feature: Demo Blaze e2e

Scenario: place order
  Given User navigate to  login page
  
  When User enters valid username "Jagadish" into username field
  
  And User enters valid password "jagadish@123" into password field
  
  And User clicks on login
  
  Then User should successfully login and "Welcome Jagadish" should be displays

	And User selects a product "Samsung galaxy s6":

  Then The product details for "Samsung galaxy s6" should be displayed:

	When User adds the product to the cart:

	Then The cart should contain "Samsung galaxy s6":

	When User click on place order button
	
	And Enter Name: "Jagadish" Country: "India" City: "Jagatsinghpur" Credit card: "37jd93740u" Month: "December" Year: "2024"
	
	And Click on purchase
	
	Then Order should place successfully
	
	When User clicks on the "Logout" button:

	Then User should be logged out successfully:
