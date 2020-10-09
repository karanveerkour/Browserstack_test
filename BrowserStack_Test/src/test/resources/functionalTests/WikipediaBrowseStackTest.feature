Feature: Wikipedia Test Automation 

Background:
  Given user is on Login page
  When The username is entered as "swatitest"
  And The password is entered as "Swatee123"
  And The login button is clicked 
 
Scenario: To create List and add search page
	When I create "List1" from landing page for "BrowserStack"
  Then I Search for BrowserStack page  
  And  I am able to add page to list
  	And I am able to click on Emulator link from searched page 
 	And  I am able to create "List2" from searched page for "Emulator"
 
Scenario: To delete list
	When I go to saved list landing page
  	Then I am able to delete saved list
 	
Scenario: To change language and theme setting
	When I go to setting page
  Then I am able to add "Hindi" language
  And  I am able to change Wikipedia theme
  

Scenario: To delete language 
  When I go to setting page
  And I am able to delete language

