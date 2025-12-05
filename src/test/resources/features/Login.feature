Feature: Search functionality 

@Search

@TC_01_Search_menu_item_and_edit_product_quantity
Scenario Outline: Search with Excel data and verify correct items are displayed

Given User is on home page for <tcNo>
When User clicks on my account and selects login button
And User verifies that he has landed on the Login page 
And User enters Username,password and clicks on login button
Then User verifies that he has successfully logged in 


Examples:
|tcNo|
|1|
