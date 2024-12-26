Feature: As a user I will access Flipkart

Scenario: Accessing Menu Items
Given User is On Flipkat homepage
And when use mouse over on menu list 
When Select Option in menu
Then Navigate to Option page
And Get All items in page store in HashMap