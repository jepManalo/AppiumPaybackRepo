Feature: PayBack Mobile Application

  Scenario: Select REWE Coupon
    Given I open PayBack application in android
    When I click coupon button
    	And I filter and activate first REWE coupon
    Then I have activated the coupon

#  Scenario Outline: Select different Coupons
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | CouponName  |
#      | REWE 			 |