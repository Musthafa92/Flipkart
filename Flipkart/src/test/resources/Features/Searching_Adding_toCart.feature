Feature: Search for Items and add them to My cart

Background: 
Given User is On Flipkat Website

Scenario: As a user I will Search for Items and add them to My cart
Given Entering Item name in Searchbox
And Filter them as per brand and price 
When Click on the Item  
Then Navigate to Item Page
And Click on Add to cart
Then Item Should added to the cart