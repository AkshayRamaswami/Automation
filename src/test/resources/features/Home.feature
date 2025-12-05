Feature: Home Page Validations 

@Search

@TC_02_hover_over_category_and_select_subCategory
Scenario Outline: Mouse Hover Over Actions

Given User is on home page for <tcNo>
When User hovers on Category on home page
And User Selects Sub category from the home page

Examples:
|tcNo|
|2|


@TC_03_Dropdown_handling
Scenario Outline: Mouse Hover Over Actions

Given User is on home page for <tcNo>
When User clicks on currency button
And User Selects us currency from the home page

Examples:
|tcNo|
|2|

@TC_05_scrolling_on_web_page
 Scenario Outline: Scrolling on the web page

Given User is on home page for <tcNo>
When User scrolls to the botton 
And User clicks on the Contact us link

Examples:
|tcNo|
|5|

