Feature: Amazon app
  Scenario: First
  Given Open Home screen
  When Click on Shop by Department from burger menu
  And Choose category "Devices & Electronics"
  And Choose sub-category category "Televisions"
  And Filter with "Smart TVs" and show results
  Then Check the total number of results match the total displayed in filter