Feature: Amazon app

  Scenario: Check the selected currency displayed for the products price
    When Go to Currency Settings and Select Country & Language
    And Change currency from USD to "AED"
    Then Assert on selected currency displayed for products

  Scenario: Check the total displayed number of results for category Smart Home | Televisions
    When Click on Shop by Department from burger menu
    And Choose category Electronics
    And Choose sub-category category Televisions
    And Filter with QLED TVs and show results
    Then Check the total number of results match the total displayed in filter

  Scenario: Check filter by department in Deals and Promotions page
    When Tab on Today's Deals
    When From Departments filter, Show see more and select "Software"
    Then Assert on choosing the correct "Software" department


  Scenario: Check Product Detail Page image swipe, Payments Option, Pricing, Stock, Add to Cart
    When Tap on the Search bar and search for "Apple"
    And Tap the picture of the product and swipe Left to Right
    Then The price of the product payment options are displayed
    And Verify stock information is showing
    And Tap and verify add to cart feature

    @Manual
    Scenario: Change currency without reinstalling the app