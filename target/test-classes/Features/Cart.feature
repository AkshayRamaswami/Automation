Feature: Cart Page Validations 

@Search

@TC_04_iframes_handling
Scenario Outline: frame handling

Given User is on home page for <tcNo>
When User hovers on Category on home page
And User Selects Sub category from the home page
Then User adds the product to the cart

Examples:
|tcNo|
|4|
