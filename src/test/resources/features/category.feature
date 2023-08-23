Feature: Amazon app
  Scenario: First
  Given Open Home screen
  When Click on Shop by Department from burger menu
  And Choose category Electronics
  And Choose sub-category category Televisions
  And Filter with QLED TVs and show results
  Then Check the total number of results match the total displayed in filter


  Scenario:  2 [Check filter by department in Deals and Promotions page]

  When Tab on Today's Deals
  And From Departments filter, Show see more
  And Select Software department
  Then Assert on choosing the correct selected department

  Scenario: 3 [Check the selected currency displayed for the products' price]

  When Go to Currency Settings
  And Select Country & Language
  And Change currency from 'USD' to 'AED'
  And Save changes
  Then Assert on selected currency displayed for Deals and Promotions products

  Scenario: 4 [Check Product Detail Page image swipe, Payments Option, Pricing, Stock, Add to Cart ]
  When Tap on the Search bar and search for "Apple"
  And Tap the picture of the product and swipe Left to Right
  Then The price of the product is displayed
  And Verify payment options are displayed
  And Verify out of stock or in stock, information is showing on the page.
  And Tap and verify add to cart feature